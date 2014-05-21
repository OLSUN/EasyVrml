package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.generator.ColorGenerator;
import com.bxh.easyvrml.generator.CoordinateGenerator;
import com.bxh.easyvrml.impl.Geometry;

public class PointSet implements Geometry {

	private Coordinate coord;			//����һ�� Coordinate �ڵ㣬��������һЩ�пռ������
	private      Color color;			//����һ�� Color �ڵ㣬Color �ڵ����һ�� color ��ʹ�ռ�ĵ�����ɫ��ϵ������
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������

	public PointSet(int count){
		this(CoordinateGenerator.getRandomCoordinate(5.0,5.0,5.0,new Point3D(0.0,0.0,0.0),count),
			 ColorGenerator.getRandomColor(count));
	}
	
	public PointSet(Coordinate coord,Color color){
		this.color = color;
		this.coord = coord;
		
		required = new HashMap<>();
		required.put("coord", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("coord", 0);
		exsisted.put("color", 1);
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
