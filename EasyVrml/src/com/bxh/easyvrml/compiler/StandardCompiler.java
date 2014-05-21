package com.bxh.easyvrml.compiler;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.bxh.easyvrml.document.VDocument;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.tools.Log;
import com.bxh.easyvrml.tools.VrmlUtils;
import com.bxh.easyvrml.tools.XMLUtils;
import com.bxh.easyvrml.impl.Compiler;
import com.bxh.easyvrml.node.basic.Version;
import com.bxh.easyvrml.node.extend.Define;
import com.bxh.easyvrml.node.extend.ROUTE;

/**
 * StandardCompiler ��������Ĵ��뷭�빤����ʵ��Java Code��XML�ļ���ת��
 * 
 * @author BXH
 */
public class StandardCompiler implements Compiler {

	public int element_index = 0;
	
	/**
	 * ����VDocument�ĵ����������ɵ���ӦDocument�������ڲ���XML�ļ�
	 */
	@Override
	public Document compileDocument(VDocument doc) {
		if(doc == null){ return null; }
		
		Document xmlDoc = XMLUtils.createDocument();	//����һ��Document�������ڴ�Ž��
		List<Node> nodes =  doc.getNodes();				//��ȡ�ĵ��е����нڵ�
		if(nodes == null){ return null; }
		
		Element root = xmlDoc.getRootElement();
		root.addElement("Version").addText(doc.getVersion().toString());
		//����ڵ�
		for(Node node : nodes){
			if(VrmlUtils.isFullyFields(node)){
				try {
					addChildElement(root,node);				//��node�ڵ��µ���������ӵ�eleԪ����
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		}
		//�����¼�·��
		List<ROUTE> routes = doc.getRoutes();
		for(ROUTE route:routes){
			root.addElement("ROUTE").addText(route.getRoute());
		}
		Log.showReport();
		return xmlDoc;
	}
	
	/**
	 *  ��ȡ���е�˽������[private��������Ҫ��������ԣ�protected�������¼�]
	 * @param fields	�����������
	 * @return	���˽������
	 */
	public Field[]	getPrivateFields(Field[] fields){
		List<Field> fieldsList = new LinkedList<Field>();						//���ڴ洢˽������
		for(Field field:fields){
			if(field.getModifiers()==2){										//�ж������Ƿ���˽������[public:1,private:2,Ĭ��:3,protected:4]
				fieldsList.add(field);
			}
		}
		return (Field[])(fieldsList.toArray(new Field[fieldsList.size()]));
	}
	
	/**
	 * �ݹ���÷��������ڱ����ڵ�����Բ�����XML Document
	 * @param ele
	 * @param node
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void addChildElement(Element ele,Node node) throws IllegalArgumentException, IllegalAccessException{
		if(Define.isContainDefine(node)&&Define.selectStates(node)){
			ele = ele.addElement("USE").addText("USE "+Define.selectDefine(node));		//����USE�ڵ�
		}else{
			Field fields[] = getPrivateFields(node.getClass().getDeclaredFields());		//��ȡ�ڵ����������
			
			if(fields!=null){
				ele = ele.addElement(VrmlUtils.getNodeName(node.getClass()))
											  .addAttribute("name",getElementName(node))
											  .addAttribute("type", node.getClass().getName());	//��ڵ������type����
				if(XMLUtils.isNode(ele.getName())){
					element_index++;
				}
				
				for(Field field : fields){
					if(VrmlUtils.isCanShow(node, field)){
						
						//��Ҫ�ж����Ե�ֵ�Ƿ���Ч
						field.setAccessible(true);										//���ýڵ����Կ��Ա�����
						Element fele = ele;
						if(field.get(node)!=null){
							fele = ele.addElement(field.getName());					//������Խڵ�
						}
						
						Log.logInfo("NodeName:" + VrmlUtils.getNodeName(node.getClass()) + "...............TypeName:"+field.getType().getSimpleName());
						
						String typeName = field.getType().getSimpleName();				//��ȡ��������
					
						if("double".equals(typeName)){									//��������Ϊdouble
							Double value = field.getDouble(node);
							if(value != null){
								fele.addAttribute("type", "double").addText(""+value);
							}
						}else if("double[]".equals(typeName)){							//��������Ϊdouble����
							double values[] = (double[])(field.get(node));
							if(values !=null&&values.length>0){
								String text = "";
								for(int i =0;i<values.length;i++){
									text = text + values[i] + " ";
								}
								fele.addAttribute("type", "double[]").addText(text.trim());
							}
						}else if("double[][]".equals(typeName)){						//��������Ϊdouble��ά����
							double values[][] = (double[][])(field.get(node));
							if(values !=null&&values.length>0){
								String text = "";
								for(int i =0;i<values.length;i++){
									for(int j=0;j<values[i].length;j++){
										text = text + values[i][j] + " ";
									}
									text = text.trim().concat(",");
								}
								fele.addAttribute("type", "double[][]").addText(text.substring(0,text.length()-1));
							}
						}else if("int[][]".equals(typeName)){							//��������Ϊint��ά����
							int values[][] = (int[][])(field.get(node));
							if(values !=null&&values.length>0){
								String text = "";
								for(int i =0;i<values.length;i++){
									for(int j=0;j<values[i].length;j++){
										text = text + values[i][j] + " ";
									}
									text = text.trim().concat(",");
								}
								fele.addAttribute("type", "int[][]").addText(text.substring(0,text.length()-1));
							}
						}else if("int[]".equals(typeName)){								//��������Ϊint����
							int values[] = (int[])(field.get(node));
							if(values !=null&&values.length>0){
								String text = "";
								for(int i =0;i<values.length;i++){
									text = text + values[i] + ",";
								}
								fele.addAttribute("type", "int[]").addText(text.substring(0,text.length()-1>=0?text.length()-1:0));
							}
						}else if("int".equals(typeName)){								//��������Ϊint����
							Integer value = field.getInt(node);	
							if(value!=null){
								fele.addAttribute("type", "int").addText(""+value);
							}
						}else if("Long".equals(typeName)){								//��������Ϊlong����
							Long value = (Long)field.get(node);	
							if(value!=null){
								fele.addAttribute("type", "long").addText(""+value);
							}
						}else if("boolean".equals(typeName)){							//��������Ϊboolean����
							Boolean value = field.getBoolean(node);
							if(value!=null){
								fele.addAttribute("type", "boolean").addText((""+value).toUpperCase());
							}
						}else if("String".equals(typeName)){							//��������Ϊboolean����
							String value = (String)(field.get(node));
							if(value!=null){
								if(fele.getParent().getName().equals("Script")&&!fele.getName().equals("url")){
									fele.addAttribute("type", "String").addText(value);
								}else{
									fele.addAttribute("type", "String").addText("\""+value+"\"");
								}
							}
						}else if("String[]".equals(typeName)){							//��������Ϊboolean����
							String values[] = (String[])(field.get(node));
							if(values !=null&&values.length>0){
								String text = "";
								for(int i =0;i<values.length;i++){
									text = text + "\"" + values[i] + "\" ";
								}
								fele.addAttribute("type", "String[]").addText(text.trim());
							}
						}else if("Node[]".equals(typeName)){							//��������Ϊboolean����
							Node[] values = (Node[])(field.get(node));
							if(values !=null&&values.length>0){
								for(int i =0;i<values.length;i++){
									if(VrmlUtils.isFullyFields(values[i])){
										addChildElement(fele.addAttribute("type", "Node[]").addAttribute("length", values.length+""),values[i]);
									}
								}
							}
						}else if(VrmlUtils.isFullyFields((Node)(field.get(node)))){															//��������Ϊboolean����
							if(XMLUtils.isNode(fele.getName())){
								element_index++;
							}
							addChildElement(fele.addAttribute("type", "Node"),(Node)(field.get(node)));
						}
					}
				}
			}
		}
	}

	/**
	 * ��ȡ�ڵ�����֣�����ýڵ��Ѿ�Ԥ�����������ʾԤ�������ƣ�������ʾ�Զ���������
	 * @param node �ڵ�
	 * @return �ڵ������
	 */
	private String getElementName(Node node) {
		String name ;
		if((name = Define.selectDefine(node))!=null){
			return name;
		}
		return "Ele_" + getElement_index();
	}
	
	public int getElement_index() {
		return element_index;
	}

	public void setElement_index(int element_index) {
		this.element_index = element_index;
	}

}
