package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;

public class Cone implements Geometry {

	private double height;				//Բ׶�߶�
	private double bottomRadius;		//����뾶
	private boolean bottom;				//�Ƿ���ʾ����
	private boolean side;				//�Ƿ���ʾ����
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public Cone(){
		this(1.0,0.5);
	}
	
	public Cone(double height,double bottomRadius){
		this(height,bottomRadius,true,true);
	}
	
	public Cone(double height,double bottomRadius,boolean bottom,boolean side){
		this.height = height;
		this.bottomRadius = bottomRadius;
		this.bottom = bottom;
		this.side = side;
		
		required = new HashMap<>();
		required.put("height", 0);
		required.put("bottomRadius", 0);

		exsisted = new HashMap<>();
		exsisted.put("height", 0);
		exsisted.put("bottomRadius", 0);
		exsisted.put("bottom", 1);
		exsisted.put("side", 1);
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBottomRadius() {
		return bottomRadius;
	}

	public void setBottomRadius(double bottomRadius) {
		this.bottomRadius = bottomRadius;
	}

	public boolean isBottom() {
		return bottom;
	}

	public void setBottom(boolean bottom) {
		this.bottom = bottom;
	}

	public boolean isSide() {
		return side;
	}

	public void setSide(boolean side) {
		this.side = side;
	}
	
}
