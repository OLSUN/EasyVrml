package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Node;

public class Sound implements Node {
	private Node 		source;			//����ֵΪ AudioClip �ڵ���� MovieTexture �ڵ㡣������߶�û��ָ�������ᷢ������
	
	private double	 intensity;			//������Դ��ǿ�ȣ�0 Ϊ��Сֵ��1 Ϊ���ֵ��
	
	private double	  priority;			//���������ļ����ŵ����ȼ������ȼ����մ� 0 �� 1 ����
	
	private double[]  location;			//������Դ����λ�õ�����
	
	private double[] direction;			//ָ���������ŵķ��򣬵���������򲢲�ͬ�����Դ����������������������
										//minFront��maxFront��minBack �Լ� maxBack ��ͬȷ�����������ŵ���Ч�����Լ�����ǿ�ȱ�
										//����˥���ķ�ʽ
	
	private double 	  minFront;			//��Сǰ�㣬��ʾ��Դλ�� location �� direction ���������򶥵�ľ���
	
	private double	  maxFront;			//���ǰ�㣬��ʾ��Դλ�� location �� direction ���������򶥵�ľ���
	
	private double	   minBack;			//��С��㣬��ʾ��Դλ�� location �� direction ���෴���������򶥵�ľ���
	
	private double	   maxBack;			//����㣬��ʾ��Դλ�� location �� direction ���෴���������򶥵�ľ��롣
	
	private boolean	spatialize;	 		//ָ����������ʲô��ʽ���š�ѡ TRUE ��ʽ����ʱ��������Ǿ��������
										//����ģ�ʹ֮�ӽ�����ʵ�е����������ѡ�� FALSE ��ʽ���������ļ��������κδ���ֱ��
										//���š�

	
	public Sound(Node source) {
		this(source,1.0,1.0,new double[]{0.0,0.0,0.0},new double[]{0.0,0.0,1.0},1.0,10.0,1.0,10.0,true);
	}

	public Sound(Node source, double intensity, double priority,double[] location, double[] direction, double minFront,
			double maxFront, double minBack, double maxBack, boolean spatialize) {
		this.source = source;
		this.intensity = intensity;
		this.priority = priority;
		this.location = location;
		this.direction = direction;
		this.minFront = minFront;
		this.maxFront = maxFront;
		this.minBack = minBack;
		this.maxBack = maxBack;
		this.spatialize = spatialize;
	}

	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public double getPriority() {
		return priority;
	}

	public void setPriority(double priority) {
		this.priority = priority;
	}

	public double[] getLocation() {
		return location;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

	public double[] getDirection() {
		return direction;
	}

	public void setDirection(double[] direction) {
		this.direction = direction;
	}

	public double getMinFront() {
		return minFront;
	}

	public void setMinFront(double minFront) {
		this.minFront = minFront;
	}

	public double getMaxFront() {
		return maxFront;
	}

	public void setMaxFront(double maxFront) {
		this.maxFront = maxFront;
	}

	public double getMinBack() {
		return minBack;
	}

	public void setMinBack(double minBack) {
		this.minBack = minBack;
	}

	public double getMaxBack() {
		return maxBack;
	}

	public void setMaxBack(double maxBack) {
		this.maxBack = maxBack;
	}

	public boolean isSpatialize() {
		return spatialize;
	}

	public void setSpatialize(boolean spatialize) {
		this.spatialize = spatialize;
	}
}
