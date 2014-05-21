package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
/*
 *����ೡ������Щ�����ڲ����ƵĶ�����������Ƶȵȡ��е�ʱ���ڲ���ʮ�ֱ������
 *���£���ľ�����ܵȵ�����ʹ����һ��ƽ������ͼ��ʵ�֣��������ڳ������ƶ��ӵ��ʱ��
 *���п��ܳ������⣬��ľ����������һ����Ƭ����������������һ�����������ƽڵ� Billboard
 *�ܹ����������⡣
 */
public class Billboard implements Node {
	private Node[] 		   children;		//��������ӽڵ���б��ӽڵ�����ͼ������ǵ��ڵ�Ҳ������Ⱥ�ڵ�
	
	private double[] axisOfRotation;  		//������������ֵ���ɸõ�ָ������ԭ��ȷ�������߹涨һ����ת��
	
	private double[]     bboxCenter;		//��Χ Billboard �ڵ��������ӽڵ�����������
	
	private double[]       bboxSize;		//��Χ Billboard �ڵ��������ӽڵ�������� X��Y��Z ����ĳߴ�
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public final EventIn 			addChildren;	//���¼�����ֵ�ڵ��͡�ͨ���¼�����������ָ���Ľڵ���뵽 Billboard �ڵ���ӽڵ��б�
													//�У�����ýڵ��Ѿ����б��У����¼������ԡ�
	
	public final EventIn 		 removeChildren;	//���¼�����ֵ�ڵ��͡�ͨ���¼�����������ָ���Ľڵ�� Billboard �ڵ���ӽڵ��б���ɾ
													//��������ýڵ�û�����б��У����¼�������

	public Billboard(Node[] children) {
		this(children,new double[]{},new double[0],new double[0]);
	}

	public Billboard(Node[] children, double[] axisOfRotation,double[] bboxCenter, double[] bboxSize) {
		this.children = children;
		this.axisOfRotation = axisOfRotation;
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		
		required = new HashMap<>();
		required.put("children", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("children", 0);
		exsisted.put("axisOfRotation", 1);
		exsisted.put("bboxCenter", 1);
		exsisted.put("bboxSize", 1);
		
		this.addChildren = new EventIn("addChildren","MFNode");
		this.removeChildren = new EventIn("removeChildren","MFNode");
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public double[] getAxisOfRotation() {
		return axisOfRotation;
	}

	public void setAxisOfRotation(double[] axisOfRotation) {
		this.axisOfRotation = axisOfRotation;
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

	public EventIn getAddChildren() {
		return addChildren;
	}

	public EventIn getRemoveChildren() {
		return removeChildren;
	}
	
}
