package com.bxh.easyvrml.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * XMLUtils �ṩ��һ������XML�ļ��Ĺ����ߣ�������ɸ��ֻ���XML�Ĳ���
 * 
 * @author BXH
 *
 */
public class XMLUtils {

	/**
	 * createDocument ���𴴽�һ��Ĭ��XML �ĵ�
	 * @return һ��Ĭ�ϵ�XML Document
	 */
	public static Document createDocument() {
		Document document = DocumentHelper.createDocument();
		document.addElement("VRML");	//��Ӹ��ڵ�VRML
		return document;
	}
	
//	public static void deleteDocument(Document){
//		FileUtils.deleteQuietly(new File())
//	}
	
	public static void listXMLDocument(Document doc){
		Element vrml = doc.getRootElement();
		for ( Iterator<Element> i = vrml.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            System.out.println(element.getTextTrim());
        }
	}
	
	
	
	/**
	 * write ��������
	 * @param doc ���ڳ־û���Document����
	 */
	public static void write(Document doc) {
		write(doc,true);		
	}
	
	/**
	 * write ��������
	 * @param doc	���ڳ־û���Document����
	 * @param isformat	�Ƿ��ʽ��
	 */
	public static void write(Document doc,boolean isformat){
		try {
			write(doc,new FileOutputStream("result.xml"),isformat);		//Ĭ�������ĵ���Ϊresult.xml
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param doc ��Ҫд��Ӳ�̵�XML �ĵ�
	 * @param writer Writer����
	 * @param isformat �Ƿ���и�ʽ��(Ĭ���ǲ����и�ʽ��)
	 */
	public static void write(Document doc,OutputStream writer,boolean isformat) {
		XMLWriter xwriter = null;
		try {
			if(isformat){
				OutputFormat format = OutputFormat.createPrettyPrint();				//��ʽ�������
				xwriter = new XMLWriter(writer,format);
			}else{
				xwriter = new XMLWriter(writer);
			}
			xwriter.write(doc);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * �жϸ����Ľڵ��Ƿ����ӽڵ�
	 * @param node
	 * @param parent
	 * @return
	 */
	public static boolean hasChildren(Element node,String parent){
		//System.out.println(parent + "/" + node.getName() +"/*" +(node.selectNodes(parent + "/" + node.getName() +"/*").size()!=0));
		return node.selectNodes(parent + "/" + node.getName() +"/*").size()>0;
	}
	
	/**
	 * �жϽڵ������Ƿ�Ϊ��
	 * @param node
	 * @return
	 */
	public static boolean hasContent(Node node){
		return node.hasContent() && !(node.getText().equals("\"\""));
	}
	
	/**
	 * ��ȡһ���ڵ�����
	 * @param path	�ڵ����ڵ�·��
	 * @return	�ڵ����������
	 */
	public static int getDeepLevel(String path){
		int deep = 0;
		String []nodes = path.substring(1, path.length() - 2).split("/");
		for(int i = 0;nodes!=null&&i < nodes.length;i++){
			int location = nodes[i].indexOf("[");
			if(isNode(location>=0?nodes[i].substring(0, location):nodes[i])){
				deep ++;
			}
		}
		return deep;
	}
	
	/**
	 * �ж�һ���ַ����Ƿ��ǽڵ���
	 * @param nodeName
	 * @return
	 */
	public static boolean isNode(String nodeName){
		return nodeName.matches("([A-Z]{1}[a-z]+)+") || nodeName.equals("ROUTE") || nodeName.equals("USE") || nodeName.equals("LOD");
	}
	
	public static Document getDocument(File file) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(file);
		return doc;
	}
}
