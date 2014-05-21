package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;

/**
 * Box ��ʾ�����壬����size(��/��/��)������
 * 
 * @author BXH
 */
public class Box implements Geometry {

	private double size[];		//Box�ĳߴ�
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public Box(){
		this(1.0 ,1.0 ,1.0);
	}
	
	public Box(double x,double y,double z){
		size =new double[]{x,y,z};
		required = new HashMap<>();
		required.put("size", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("size", 0);
	}
	
	public double getX() {
		return size[0];
	}
	
	public double getY() {
		return size[2];
	}
	
	public double getZ() {
		return size[1];
	}

	public void setX(double x) {
		this.size[0] = x;
	}
	
	public void setY(double y) {
		this.size[2] = y;
	}
	
	public void setZ(double z) {
		this.size[1] = z;
	}

	@Override
	public Box clone() throws CloneNotSupportedException {
		Box box = new Box();
		box.setX(getX());
		box.setY(getY());
		box.setZ(getZ());
		return box;
	}
}
