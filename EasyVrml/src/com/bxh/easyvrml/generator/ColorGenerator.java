package com.bxh.easyvrml.generator;

import java.math.BigDecimal;
import java.util.Random;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.node.basic.Color;
import com.bxh.easyvrml.node.basic.Coordinate;
import com.bxh.easyvrml.tools.ColorConfig;
import com.bxh.easyvrml.tools.MathUtils;
/**
 * �������ɻ���3ά�ռ�����ĵ㼯
 * 
 * @author BXH
 */
public class ColorGenerator {
	
	//���һ��ָ�������������ɫ��
	public static Color getRandomColor(int count){
		Color color = new Color();
		double [][]colors = new double[count][3]; 
		Random ran = new Random();
		for(int i=0;i<count;i++){
			colors[i][0] = MathUtils.divide(ran.nextDouble());
			colors[i][1] = MathUtils.divide(ran.nextDouble());
			colors[i][2] = MathUtils.divide(ran.nextDouble());
		}
		color.setColor(colors);
		return color;
	}
	
	//��ȡһ��ָ����ɫ���͵ĵ�ɫColor����
	public static Color getSingleColorByType(int count,int color){
		switch(color){
		case ColorConfig.SOFT_COLOR_RED:
			return getSingleColor(count,new double[]{1.0,0.0,0.0});
		case ColorConfig.SOFT_COLOR_GREEN:
			return getSingleColor(count,new double[]{0.0,1.0,0.0});
		case ColorConfig.SOFT_COLOR_BLUE:
			return getSingleColor(count,new double[]{0.0,0.0,1.0});
		}
		return getSingleColor(count,new double[]{1.0,1.0,1.0});				//Ĭ�Ϸ��ذ�ɫ
	}
	
	//���ָ�������ĵ�ɫ��ɫ��
	public static Color getSingleColor(int count,double color[]){
		Color _color = new Color();
		double [][]_colors = new double[count][3]; 
		for(int i=0;i<count;i++){
			_colors[i][0] = color[0];
			_colors[i][1] = color[1];
			_colors[i][2] = color[2];
		}
		_color.setColor(_colors);
		return _color;
	}
}
