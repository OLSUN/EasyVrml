package com.bxh.easyvrml.analyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.bxh.easyvrml.document.VDocument;
import com.bxh.easyvrml.document.VrmlCodeStream;
import com.bxh.easyvrml.impl.Analyzer;
import com.bxh.easyvrml.node.extend.Define;
import com.bxh.easyvrml.tools.Log;
import com.bxh.easyvrml.tools.MathUtils;
import com.bxh.easyvrml.tools.XMLUtils;

public class StandardAnalyzer implements Analyzer {
	
	private StringBuffer content = new StringBuffer();
	
	
	//���ڽ���Document�ļ������ɶ�Ӧ��VRML����
	@Override
	public VrmlCodeStream parseDocument(Document xmlDoc){
		if(checkDocument(xmlDoc)){

			Log.logInfo(">>Begin the Analyzer Process...");
			VrmlCodeStream code = new VrmlCodeStream();			//����VrmlCodeStream���ڱ��������������մ���
			//��document���н���
			Element root = xmlDoc.getRootElement();
			
			@SuppressWarnings("unchecked")
			List<Element> list = (List<Element>)(root.selectNodes("/" + root.getName()+"/*"));		//��ȡ���и��ڵ��µ��ӽڵ�
			if(list!=null){
				double i = 0;
				double t = 100.0/list.size();
				for(Iterator<Element> itr = list.iterator();list!=null&&itr.hasNext();){
					parseChildElement("/"+root.getName(),itr.next());
					i+=t;
					Log.logInfo(">>Have Analyzed The VDocument........................................[ " + MathUtils.divide(i,1) + "% ]");
				}
			}
			code.setContent(content);
			Log.logInfo(">>Finished the Analyzer Process!");
			return code;
		}
		return null;
	}
	
	
	/**
	 * ����ָ��·���µĽڵ���Ϣ
	 * @param parent	�ڵ�����·��
	 * @param node ��Ҫ�����Ľڵ�
	 * @throws UnsupportedEncodingException 
	 */
	public void parseChildElement(String parent,Element node){
		int length =0 ;
		
		if(XMLUtils.isNode(node.getName())){					//�ڵ���Node
			if("Version".equals(node.getName())|| "ROUTE".equals(node.getName()) || "USE".equals(node.getName())){
				if(VDocument.isPrintCode){
					System.out.println(node.getText());				//��ӡVersion�ڵ���Ϣ
				}
				content.append(node.getText()+"\n");
				
			}else{				//�����Version�ڵ�Ļ�ֱ�ӷ��룬���������Version�ڵ㲻��Ҫ��ʾ�ڵ�����
//				for(int i = 0 ;i < XMLUtils.getDeepLevel(parent);i++){
//					System.out.print("    ");
//					content.append("    ");
//				}
				if(isHasCheckedName(node.attributeValue("name"))){
					if(VDocument.isPrintCode){
						System.out.print("DEF " + node.attributeValue("name") + " " + node.getName() + " {\n");		//DEF name Shape {
					}
					content.append("DEF " + node.attributeValue("name") + " " + node.getName() + " {\n");
				}else{
					if(VDocument.isPrintCode){
						System.out.print(node.getName() + " {\n");		//Shape {
					}
					content.append(node.getName() + " {\n");
				}
				
				@SuppressWarnings("unchecked")
				List<Element> list = node.selectNodes(parent + "//" + node.getName()+ "[@name='"+node.attributeValue("name")+ "']/*");	//���node������ӽڵ�
				for(Iterator<Element> itr = list.iterator();list!=null&&itr.hasNext();){
					Element ele = itr.next();
					parseChildElement(parent + "/" + node.getName() + "[@name='"+node.attributeValue("name")+ "']",ele);
				}
				
				//���������ŵ�����λ���Ǹýڵ�ĸ��ڵ������λ��
				for(int i = 0 ;i < XMLUtils.getDeepLevel(parent);i++){
					if(VDocument.isPrintCode){
						System.out.print("    ");
					}
					content.append("    ");
				}
				if(VDocument.isPrintCode){
					System.out.print("}\n");
				}
				content.append("}\n");
			}
		}else{	
			//�ӵ���Field
			boolean isHasContent = XMLUtils.hasContent(node);
			boolean isHasChildren = XMLUtils.hasChildren(node, parent);
			
			if(isHasContent){						//�ж����Խڵ��Ƿ������ݣ����û�еĻ��Ͳ����з���
				for(int i =0 ;i < XMLUtils.getDeepLevel(parent + "/" + node.getName());i++){
					if(VDocument.isPrintCode){
						System.out.print("    ");
					}
					content.append("    ");
				}
				if(isHasChildren){		//���ӽڵ�
					String type = node.attributeValue("type");
					
					if("Node[]".equals(type)){
						length = Integer.parseInt(node.attributeValue("length"));
						if(VDocument.isPrintCode){
							System.out.print(node.getName() + " [\n");
						}
						content.append(node.getName() + " [\n");
						if(length==1){
							for(int i = 0 ;i < XMLUtils.getDeepLevel(parent);i++){
								if(VDocument.isPrintCode){
									System.out.print("    ");
								}
								content.append("    ");
							}
						}
					}else if("Node".equals(type)){
						if(VDocument.isPrintCode){
							System.out.print(node.getName() + " ");
						}
						content.append(node.getName() + " ");
					}
					
					@SuppressWarnings("unchecked")
					List<Element> list = node.selectNodes(parent + "/" + node.getName() + "/*");
					for(Iterator<Element> itr = list.iterator();list!=null&&itr.hasNext();){
						if("Node[]".equals(type)&&length>1){
							for(int i = 0 ;i < XMLUtils.getDeepLevel(parent);i++){
								if(VDocument.isPrintCode){
									System.out.print("    ");
								}
								content.append("    ");
							}
						}
						Element next = itr.next();
						parseChildElement(parent + "/" + node.getName(),next);
					}
					
					if("Node[]".equals(type)){
						for(int i = 0 ;i < XMLUtils.getDeepLevel(parent);i++){
							if(VDocument.isPrintCode){
								System.out.print("    ");
							}
							content.append("    ");
						}
						if(VDocument.isPrintCode){
							System.out.print("]\n");
						}
						content.append("]\n");
					}
				}
				
				if(isHasContent&&!isHasChildren){	//ֻ�����ݶ����ӽڵ�		
					String type = node.attributeValue("type");
					if(type!=null){
						if(type.equals("double[]") ||type.equals("String[]") || type.equals("double[][]") || type.equals("int[]")){
							if(type.equals("double[]")){
								if(!(node.getParent().getName().equals("Material"))&&
								   !(node.getParent().getName().equals("Transform"))&&
								   !(node.getParent().getName().equals("Box"))&&
								   !(node.getParent().getName().equals("Viewpoint"))&&
								   !(node.getParent().getName().equals("TextureTransform"))&&
								   !(node.getParent().getName().equals("Anchor"))&&
								   !(node.getParent().getName().equals("Inline"))&&
								   !(node.getParent().getName().equals("Fog"))&&
								   !(node.getParent().getName().equals("Group"))&&
								   !(node.getParent().getName().equals("Sound"))&&
								   (node.getParent().getName().equals("LOD") && node.getName().equals("range"))||
								   (node.getParent().getName().equals("ColorInterpolator"))
								  ){
									if(VDocument.isPrintCode){
										System.out.print(node.getName() + " [" +node.getText() +"]\n");
									}
									content.append(node.getName() + " [" +node.getText() +"]\n");
								}else{
									if(VDocument.isPrintCode){
										System.out.print(node.getName() + " " +node.getText() +"\n");
									}
									content.append(node.getName() + " " +node.getText() +"\n");
								}
							}else if(type.equals("String[]")){
								if(!(node.getParent().getName().equals("Anchor"))){
									if(VDocument.isPrintCode){
										System.out.print(node.getName() + " [" +node.getText() +"]\n");
									}
									content.append(node.getName() + " [" +node.getText() +"]\n");
								}else{
									if(VDocument.isPrintCode){
										System.out.print(node.getName() + " " +node.getText() +"\n");
									}
									content.append(node.getName() + " " +node.getText() +"\n");
								}
							}else{
								if(VDocument.isPrintCode){
									System.out.print(node.getName() + " [" + node.getText() +"]\n");
								}
								content.append(node.getName() + " [" +node.getText() +"]\n");
							}
						}else{
							if(VDocument.isPrintCode){
								System.out.print(node.getName() + " " +node.getText() +"\n");
							}
							content.append(node.getName() + " " +node.getText() +"\n");
						}
					}
				}
			}
		}
	}
	
	private boolean isHasCheckedName(String str){
		return str!=null&&(!str.startsWith("Ele_"));
	}

	//���ڼ�����ɵ��м�������ȷ��
	@Override
	public boolean checkDocument(Document xmlDoc) {
		
		return true;
	}
}
