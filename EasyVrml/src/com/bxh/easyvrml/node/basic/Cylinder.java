package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;
/**
 * Cylinder Բ����
 * 
 * @author BXH
 */
public class Cylinder implements Geometry {

	private double height;				//Բ����߶�
	private double radius;				//Բ�������뾶
	private boolean side;				//�Ƿ���ʾԲ������
	private boolean bottom;				//�Ƿ���ʾ�µ���
	private boolean top;				//�Ƿ���ʾ�ϵ���
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	
	public Cylinder(){
		this(1.0,0.5);
	}
	
	public Cylinder(double height,double radius){
		this(height,radius,true,true,true);
	}
	
	public Cylinder(double height,double radius,boolean isShowSide,boolean isShowBottom,boolean isShowTop){
		this.height = height;
		this.radius = radius;
		this.bottom = isShowBottom;
		this.side = isShowSide;
		this.top = isShowTop;
		
		required = new HashMap<>();
		required.put("height", 0);
		required.put("radius", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("height", 0);
		exsisted.put("radius", 0);
		exsisted.put("bottom", 1);
		exsisted.put("side", 1);
		exsisted.put("top", 1);
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}

	public boolean isSide() {
		return side;
	}

	public void setSide(boolean side) {
		this.side = side;
	}

	public boolean isBottom() {
		return bottom;
	}

	public void setBottom(boolean bottom) {
		this.bottom = bottom;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}
}
