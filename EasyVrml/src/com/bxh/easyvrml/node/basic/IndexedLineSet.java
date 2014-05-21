package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;
import com.bxh.easyvrml.node.extend.EventIn;

public class IndexedLineSet implements Geometry {
	private  Coordinate	     coord;			//�����ṩ�ռ��߶εĶ���ĵ�����
	
	private  int[] 	    coordIndex;			//��Ӧ Coordinate �ڵ�� point ��������б��һ�������б� ������������˳�����������
											//�ڳ����й������������γ��߶λ�������
	
	private  Color 		     color;			//��ֵ�� Color �ڵ㣬Color �ڵ����ֵҲ�� color�����г���������Ϊÿ���߶εĶ������
											//�����ɫ��һ����ɫ�б�
	
	private  int[] 	    colorIndex; 		//��Ӧ Color �ڵ�� color ��ֵ�������б�
	
	private boolean colorPerVertex;			//����� color ����һ�� Color �ڵ��������ɫ�б� ����������ֵָ���ǰѶ�Ӧ����ɫ��
											//��ÿ�����㣬���Ǹ���ÿ������
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public IndexedLineSet(){
		required = new HashMap<>();

		exsisted = new HashMap<>();
		exsisted.put("coord", 0);
		exsisted.put("coordIndex", 0);
		exsisted.put("color", 0);
		exsisted.put("colorIndex", 0);
		exsisted.put("colorPerVertex", 1);
	}
	
	public IndexedLineSet(Coordinate coord,int[] coordIndex,Color color,int[] colorIndex,boolean colorPerVertex){
		this.coord = coord;
		this.colorIndex = coordIndex;
		this.color = color;
		this.colorIndex = colorIndex;
		this.colorPerVertex = colorPerVertex;
		
		required = new HashMap<>();

		exsisted = new HashMap<>();
		exsisted.put("coord", 0);
		exsisted.put("colorIndex", 0);
		exsisted.put("color", 0);
		exsisted.put("colorIndex", 0);
		exsisted.put("colorPerVertex", 1);
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public int[] getCoordIndex() {
		return coordIndex;
	}

	public void setCoordIndex(int[] coordIndex) {
		this.coordIndex = coordIndex;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int[] getColorIndex() {
		return colorIndex;
	}

	public void setColorIndex(int[] colorIndex) {
		this.colorIndex = colorIndex;
	}

	public boolean isColorPerVertex() {
		return colorPerVertex;
	}

	public void setColorPerVertex(boolean colorPerVertex) {
		this.colorPerVertex = colorPerVertex;
	}
	
}
