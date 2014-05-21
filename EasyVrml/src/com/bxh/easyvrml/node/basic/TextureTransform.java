package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class TextureTransform implements Node {
	private double[] translation;		//ȷ����������ϵ��ƽ��
	
	private double 		rotation;		//ָ��һ���� center ���ж������������Ϊԭ�����ת����ֵ�Ի��ȱ�ʾ����ת����������
										//��ϵ������������
	
	private double[]        scale;		//ָ��һ���� center ���ж������������Ϊԭ�������
	
	private double[]	   center;		//������������һ�����ź���ת����������
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public TextureTransform() {
		this(new double[]{0,0},0,new double[]{1,1},new double[]{0,0});
	}

	public TextureTransform(double[] translation, double rotation,double[] scale, double[] center) {
		this.translation = translation;
		this.rotation = rotation;
		this.scale = scale;
		this.center = center;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("translation", 1);
		exsisted.put("rotation", 1);
		exsisted.put("scale", 1);
		exsisted.put("center", 1);
	}
	
	public double[] getTranslation() {
		return translation;
	}
	
	public void setTranslation(double[] translation) {
		this.translation = translation;
	}
	public double getRotation() {
		return rotation;
	}
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
	public double[] getScale() {
		return scale;
	}
	public void setRcale(double[] scale) {
		this.scale = scale;
	}
	public double[] getCenter() {
		return center;
	}
	public void setCenter(double[] center) {
		this.center = center;
	}
}
