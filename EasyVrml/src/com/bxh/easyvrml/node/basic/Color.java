package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Color implements Node {
	
	private double color[][];		//��ά�����ɫ
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public Color(){
		this(new double[0][0]);
	}
	
	public Color(double [][]color){
		this.color = color;
		
		required = new HashMap<>();
		required.put("color", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("color", 0);
	}

	public double[][] getColor() {
		return color;
	}

	public void setColor(double[][] color) {
		this.color = color;
	}
}
