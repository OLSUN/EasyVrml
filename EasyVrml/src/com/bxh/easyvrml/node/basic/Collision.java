package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;

/**
 * �� VRML �У�����һ��Ⱥ�ڵ� Collision����Ϊ���ܹ����ɱ�Ľڵ���Ϊ�Լ����ӽڵ㡣��
 *�����Ⱥ�ڵ���Ҫ����Ϊ��֪�����ã���������Ӧ����ߺͳ����е��������ǳ��ӽ�ʱ��
 *���󡣸����ʱ��Collision ����������ļ�⣬����������Ӧ���ں������۸�֪����ʱ��
 *�����ص�ѧϰ����ڵ�
 *
 * @author BXH
 */
public class Collision implements Node {
	private Node[]		 children;  		//�����ڵ���߽ڵ��飬��Щ�ڵ�ͽڵ��齫��Ϊ�������ײ�Ķ���
	
	private boolean		  collide;			//ȷ���ڵ���ӽڵ��Ƿ�Ҫ������ײ��⡣����� TRUE����Ҫ������ײ���
	
	private Node		    proxy;			//��Ϊһ������ȡ�� children ���н�����ײ�����ӽڵ����
	
	private double[] bboxCenter;			//��Χ Collision �ڵ�������ӽڵ�����������
	
	private double[]   bboxSize;			//��Χ Collision �ڵ�������ӽڵ�������� X��Y��Z �����ϵĳߴ�
	
	protected Map<String, Integer> required; // ��������

	protected Map<String, Integer> exsisted; // �Ѵ�������
	
	public final EventIn 	  addChildren;			//�����¼�����ֵ�ڵ��͡���ָ���Ľڵ���뵽 Collision �ڵ���ӽڵ��б���
	
	public final EventIn removeChildren;			//�����¼�����ֵ�ڵ��͡���ָ���ڵ�� Collision �ڵ���ӽڵ��б���ɾ��
	
	public final EventOut   collideTime;			//����¼�����ֵʱ���͡������⵽����ײ������ʱ�䡣
	
	public Collision(Node[] children,Node proxy) {
		this(children,true,proxy,new double[]{0.0,0.0,0.0},new double[]{-1,-1,-1});
	}
	
	public Collision(Node[] children, boolean collide, Node proxy,double[] bboxCenter, double[] bboxSize) {
		this.children = children;
		this.collide = collide;
		this.proxy = proxy;
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		
		required = new HashMap<>();
		required.put("children", 0);
		required.put("proxy", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("children", 1);
		exsisted.put("collide", 1);
		exsisted.put("proxy", 0);
		exsisted.put("bboxCenter", 1);
		exsisted.put("bboxSize", 1);
		
		addChildren = new EventIn("addChildren","MFNode");
		removeChildren = new EventIn("removeChildren","MFNode");
		collideTime = new EventOut("collideTime","SFTime");
	}
	public Node[] getChildren() {
		return children;
	}
	public void setChildren(Node[] children) {
		this.children = children;
	}
	public boolean isCollide() {
		return collide;
	}
	public void setCollide(boolean collide) {
		this.collide = collide;
	}
	public Node getProxy() {
		return proxy;
	}
	public void setProxy(Node proxy) {
		this.proxy = proxy;
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

	public EventOut getCollideTime() {
		return collideTime;
	}
}
