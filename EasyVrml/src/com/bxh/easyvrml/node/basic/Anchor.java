package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;

public class Anchor implements Node {

	private Node[]			children;			//���ڸ����е��ӽڵ���Ϊָ���� url ����ָ���������ļ��ĳ������ӵ�ê��
	
	private String[]	 description;			//�������ӵ��ı���ʾ���ƶ���굽ê�������������ʱ���������ʾ��ʾ�ı����Ը���
												//���ṩ��Ҫ��˵����
	
	private String[] 	   parameter;			//Ϊ VRML �� HTML ��������ӵ���Ϣ,��һ�����������Ե��ַ�����ʽΪ�� �ؼ���=ֵ��
												//����ʽ
	
	private String[]			 url;			//ָ��Ҫ����װ����ļ���·��
	
	private double[]	  bboxCenter;			//��Χ Anchor �������ӽڵ����İ�Χ���������
	
	private double[]		bboxSize;			//��Χ Anchor �������ӽڵ����İ�Χ������ X��Y��Z �����ϵĳߴ�

	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public final EventIn 		addChildren;			//���¼�����ֵ�ڵ��͡�������¼��������� Anchor �ڵ�� children �����ӽڵ������м���
												//ָ���Ľڵ㡣���ָ���ӽڵ��Ѿ��������ӽڵ������У�����Ա��¼�
	
	public final EventIn	 removeChildren;			//���¼�����ֵ�ڵ��͡��� A nchor �ڵ�� children �����ӽڵ�������ɾ��ָ���Ľڵ㡣���
												//ָ���ӽڵ㲻���ӽڵ������У�����Ա��¼��� 
	
	
	public Anchor(Node[] children,String[] url) {
		this(children,new String[]{"Anchor"},new String[]{""},url,new double[3],new double[3]);
	}

	public Anchor(Node[] children, String[] description, String[] parameter,
			String[] url, double[] bboxCenter, double[] bboxSize) {
		this.children = children;
		this.description = description;
		this.parameter = parameter;
		this.url = url;
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		
		required = new HashMap<>();
		required.put("children", 0);
		required.put("url", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("children", 0);
		exsisted.put("url", 1);
		exsisted.put("description", 1);
		exsisted.put("parameter", 1);
		exsisted.put("bboxCenter", 2);
		exsisted.put("bboxSize", 2);
		
		this.addChildren = new EventIn("addChildren","MFNode");
		this.removeChildren = new EventIn("removeChildren","MFNode");
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public String[] getParameter() {
		return parameter;
	}

	public void setParameter(String[] parameter) {
		this.parameter = parameter;
	}

	public String[] getUrl() {
		return url;
	}

	public void setUrl(String[] url) {
		this.url = url;
	}

	public double[] getBboxCenter() {
		return bboxCenter;
	}

	public void setBboxCenter(double[] bboxCenter) {
		this.bboxCenter = bboxCenter;
	}

	public double[] getBboxSize() {
		return bboxSize;
	}

	public void setBboxSize(double[] bboxSize) {
		this.bboxSize = bboxSize;
	}
	
}
