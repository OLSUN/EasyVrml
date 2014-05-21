package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;
import com.bxh.easyvrml.impl.Node;

public class Shape implements Node {

	private Appearance appearance;		//Ԫ��������ԣ�������ɫ�������Լ�����ȵ�
	private   Geometry geometry;		//Ԫ�ؼ�������
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public Shape(){
		this(new Appearance(),new Box());
	}
	
	public Shape(Geometry geometry){
		this(new Appearance(),geometry);
	}
	
	public Shape(Geometry geometry,int colorType){
		this(new Appearance(new Material(colorType)),geometry);
	}
	
	public Shape(Geometry geometry,String image){
		this(new Appearance(new ImageTexture(image)),geometry);
	}
	
	public Shape(Appearance appearance , Geometry geometry){
		this.appearance = appearance;
		this.geometry   = geometry;
		
		required = new HashMap<>();
		required.put("geometry", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("appearance", 1);
		exsisted.put("geometry", 0);
	}
	
	public Appearance getAppearance() {
		return appearance;
	}

	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

}
