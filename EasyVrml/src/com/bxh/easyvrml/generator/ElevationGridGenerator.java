package com.bxh.easyvrml.generator;

import java.math.BigDecimal;
import java.util.Random;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.node.basic.Color;
import com.bxh.easyvrml.node.basic.Coordinate;
import com.bxh.easyvrml.node.basic.ElevationGrid;
import com.bxh.easyvrml.tools.MathUtils;
/**
 * �������ɻ���3ά�ռ�����ĵ㼯
 * 
 * @author BXH
 */
public class ElevationGridGenerator {

	//���һ��ָ����������ɫ��
	public static ElevationGrid getRandomElevationGrid(int xDimension, double xSpacing, int zDimension,double zSpacing,double scale){
		ElevationGrid elevation = new ElevationGrid();
		double []height = new double[xDimension*zDimension]; 
		Random ran = new Random();
		for(int i=0;i<height.length;i++){
			height[i] = MathUtils.divide(ran.nextDouble()*scale);
		}
		elevation.setHeight(height);
		elevation.setCreaseAngle(1.0);
		elevation.setColorPerVertex(false);
		elevation.setxDimension(xDimension);
		elevation.setxSpacing(xSpacing);
		elevation.setzDimension(zDimension);
		elevation.setzSpacing(zSpacing);
		//elevation.setColor(ColorGenerator.getRandomColor(xDimension*zDimension));
		elevation.setColor(ColorGenerator.getSingleColor(xDimension*zDimension, new double[]{1.0,0.0,0.0}));
		return elevation;
	}
}
