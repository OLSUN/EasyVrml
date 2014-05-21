package com.bxh.easyvrml.generator;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Random;

import org.hamcrest.CoreMatchers;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.impl.Geometry;
import com.bxh.easyvrml.node.basic.Color;
import com.bxh.easyvrml.node.basic.Coordinate;
import com.bxh.easyvrml.node.basic.IndexedLineSet;
import com.bxh.easyvrml.tools.ColorConfig;
import com.bxh.easyvrml.tools.VrmlUtils;
/**
 * �������ɻ���3ά�ռ�����ĵ㼯
 * 
 * @author BXH
 */
public class IndexedLineGenerator {

	/*public static IndexedLineSet connectLine(IndexedLineSet line1,IndexedLineSet line2){
		IndexedLineSet line = new Index
		
	}*/
	
	/**
	 * ��ȡһ���߶εĶ˵�
	 * @param line �߶�
	 * @return �˵�
	 */
	public static Point3D[] getEndPointsOfLine(IndexedLineSet line){
		try {
			Point3D _points[] = new Point3D[2];
			Field _coord = line.getClass().getDeclaredField("coord");
			_coord.setAccessible(true);
			Coordinate coord = (Coordinate)_coord.get(line);
			double _cd[][] = coord.getPoint();
			_points[0] = new Point3D(_cd[0][0],_cd[0][1],_cd[0][2]);
			_points[1] = new Point3D(_cd[_cd.length-1][0],_cd[_cd.length-1][1],_cd[_cd.length-1][2]);
			return _points;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static IndexedLineSet getCoordinate(){
		IndexedLineSet line = new IndexedLineSet();
		line.setColor(new Color(new double[][]{{1.0,0.0,0.0},{1.0,0.0,0.0},
											   {0.0,1.0,0.0},{0.0,1.0,0.0},
											   {0.0,0.0,1.0},{0.0,0.0,1.0}}));
		line.setColorIndex(new int[]{0,1,2,3,4,5});
		
		line.setCoord(new Coordinate(new double[][]{{10,0,0},{-10,0,0},{0,10,0},{0,-10,0},{0,0,10},{0,0,-10}}));
		line.setCoordIndex(new int[]{0,1,-1,2,3,-1,4,5,-1});
		line.setColorPerVertex(true);
		return line;
	}
	
	/**
	 * ���һ��������ʼ����ս��ȷ���Ŀռ�ֱ��
	 * @param start	��ʼ��
	 * @param end �ս��
	 * @return	���ӵ��߶�
	 */
	public static IndexedLineSet getLine(Point3D start,Point3D end){
		IndexedLineSet line = new IndexedLineSet();
		line.setColor(ColorGenerator.getSingleColorByType(2, ColorConfig.SOFT_COLOR_BLUE));
		line.setColorIndex(new int[]{0,1});
		
		line.setCoord(new Coordinate(new double[][]{{start.getX(),start.getY(),start.getZ()},{end.getX(),end.getY(),end.getZ()}}));
		line.setCoordIndex(new int[]{0,1,-1});
		line.setColorPerVertex(false);
		return line;
	}
	
	/**
	 * �Ը����ĵ㼯���������γ�ֱ��
	 * @param points	��Ҫ�������ӵĵ㼯
	 * @param colorType	�����ߵ���ɫ
	 * @return	������ɵ��߶�
	 */
	public static IndexedLineSet getLineByPoints(Point3D []points,int colorType){
		IndexedLineSet line = new IndexedLineSet();
		
		line.setColor(ColorGenerator.getSingleColorByType(points.length, colorType));
		int colorindex[] = new int[points.length];
		for(int i = 0;i<colorindex.length;i++){colorindex[i] =  i;}
		line.setColorIndex(colorindex);
		
		double coordinate[][] = new double[points.length][3];
		for(int i = 0;i<points.length ;i++){
			coordinate[i][0] = points[i].getX();
			coordinate[i][1] = points[i].getY();
			coordinate[i][2] = points[i].getZ();
		}
		line.setCoord(new Coordinate(coordinate));
		
		int []coordindex = new int[3*(points.length - 1)];
		for(int i=0,j=0;i < coordinate.length -1&&j < coordindex.length -2;i++,j+=3){
			coordindex[j] = i;
			coordindex[j+1] = i+1;
			coordindex[j+2] = -1;
		}
		line.setCoordIndex(coordindex);
		line.setColorPerVertex(true);
		return line;
	}
	
	/**
	 * ���ô����Point3D�������������״ͼ�Ļ���
	 * @param montane Point3D����
	 * @param colorType ������״ͼ����ɫ
	 * @return	������ɵ�������״ͼ
	 */
	public static IndexedLineSet getLineSetByPoints(Point3D [][]montane,int colorType){
		IndexedLineSet line = new IndexedLineSet();
		
		line.setColor(ColorGenerator.getSingleColorByType(montane.length*montane[0].length, colorType));
		int colorindex[] = new int[montane.length*montane[0].length];
		for(int i = 0;i<colorindex.length;i++){colorindex[i] =  i;}
		line.setColorIndex(colorindex);
		
		double coordinate[][] = new double[montane.length*montane[0].length][3];
		
		for(int _i = 0;_i < montane.length ;_i++){
			for(int j =0;j < montane[0].length;j++){
				coordinate[_i*montane[_i].length + j][0] = montane[_i][j].getX();
				coordinate[_i*montane[_i].length + j][1] = montane[_i][j].getY();
				coordinate[_i*montane[_i].length + j][2] = montane[_i][j].getZ();
			}
		}
		
		int []coordindex = new int[3*((montane.length*(montane[0].length-1))+(montane[0].length*(montane.length - 1)))];
		int _j = 0;
		int i = 0;
		int location = 0;
		for(int _i = 0;_i < montane.length ;_i++){
			for(int _ii = 0;_ii < montane[0].length - 1&&_j < coordindex.length -2;_ii++,i++,_j+=3){
				location = _i*montane[0].length+_j;
				coordindex[location] = i;
				coordindex[location+1] = i+1;
				coordindex[location+2] = -1;
			}
			i++;
			_j-=montane[0].length;
		}
		
		_j = location + 3;
		for(int _i = 0;_i < montane[0].length ;_i++){
			for(int _ii = 0;_ii < montane.length - 1&&_j < coordindex.length -2;_ii++,_j+=3){
				coordindex[_j] = _i+_ii*montane[0].length;
				coordindex[_j+1] = _i+(_ii+1)*montane[0].length;
				coordindex[_j+2] = -1;
			}
		}
		line.setCoord(new Coordinate(coordinate));
		line.setCoordIndex(coordindex);
		
		line.setColorPerVertex(true);
		return line;
	}
	
	/**
	 * ����һ����״��
	 * @param coord	��״������������
	 * @param widthDimension	�����ȷ����ϵ�����
	 * @param wSpacing	��������Ŀ��
	 * @param lengthDimension	���񳤶ȷ����ϵ�����
	 * @param lSpacing	��������ĳ���
	 * @param colorType	��������ɫ
	 * @return ������ɵ�����
	 */
	public static IndexedLineSet getLineSet(Point3D coord,int widthDimension,double wSpacing,int lengthDimension,double lSpacing,int colorType){
		IndexedLineSet line = new IndexedLineSet();
		
		line.setColor(ColorGenerator.getSingleColorByType(4*(widthDimension + lengthDimension - 1), colorType));
		int colorindex[] = new int[4*(widthDimension + lengthDimension - 1)];
		for(int i = 0;i<colorindex.length;i++){colorindex[i] =  i;}
		line.setColorIndex(colorindex);
		
		double coordinate[][] = new double[4*(widthDimension + lengthDimension - 1)][3];
		//�ؿ�ȷ�������ƶ�
		int _i = 0;
		for(int i = -widthDimension + 1;i < widthDimension;i++,_i+=2){
			coordinate[_i][0] = coord.getX() + i * wSpacing;
			coordinate[_i][1] = coord.getY();
			coordinate[_i][2] = coord.getZ() + (lengthDimension - 1)*lSpacing;
			
			coordinate[_i + 1][0] = coord.getX() + i * wSpacing;
			coordinate[_i + 1][1] = coord.getY();
			coordinate[_i + 1][2] = coord.getZ() - (lengthDimension - 1)*lSpacing;
		}
		
		//�ظ߶ȷ�������ƶ�
		for(int j = -lengthDimension + 1;j < lengthDimension;j++,_i+=2){
			coordinate[_i][0] = coord.getX() + (widthDimension - 1)*wSpacing;
			coordinate[_i][1] = coord.getY();
			coordinate[_i][2] = coord.getZ() + j*lSpacing;
			
			coordinate[_i + 1][0] = coord.getX() - (widthDimension - 1)*wSpacing;
			coordinate[_i + 1][1] = coord.getY();
			coordinate[_i + 1][2] = coord.getZ() + j*lSpacing;
		}
		int []coordindex = new int[6*(widthDimension+lengthDimension-1)];
		for(int i=0,j=0;i < coordinate.length -1&&j < coordindex.length -2;i+=2,j+=3){
			coordindex[j] = i;
			coordindex[j+1] = i+1;
			coordindex[j+2] = -1;
		}
		line.setCoord(new Coordinate(coordinate));
		line.setCoordIndex(coordindex);
		
		line.setColorPerVertex(true);
		return line;
	}
	
	/**
	 * ����һ����������
	 * @param width	������Ŀ�
	 * @param length ������ĳ�
	 * @param height ������ĸ�
	 * @return ������ɵ�������
	 */
	public static IndexedLineSet getLineBox(double width,double length,double height){
		return getLineBox(new Point3D(), width, length, height);
	}
	
	/**
	 * ���һ��ָ�������������������
	 * @param width	������Ŀ�
	 * @param length ������ĳ�
	 * @param height ������ĸ�
	 * @return ������ɵ�������
	 */
	public static IndexedLineSet getLineBox(Point3D coord,double width,double length,double height){
		IndexedLineSet line = new IndexedLineSet();
		double coordinate[][] = new double[8][3];
		for(int i = 0;i<coordinate.length;i++){
			coordinate[i][0] = coord.getX() + (Math.pow(-1, i/2))*(width/2);
			coordinate[i][1] = coord.getY() + (Math.pow(-1, i/4))*(height/2);
			coordinate[i][2] = coord.getZ() + (Math.pow(-1, (i/2%2==0?(i%2):(i%2==0?(1):(0))))*(length/2));
		}
		line.setCoord(new Coordinate(coordinate));
		line.setCoordIndex(new int[]{0,1,-1,1,2,-1,2,3,-1,3,0,-1,4,5,-1,5,6,-1,6,7,-1,7,4,-1,0,4,-1,1,5,-1,2,6,-1,3,7,-1});
		
		line.setColor(ColorGenerator.getSingleColorByType(8, ColorConfig.SOFT_COLOR_BLUE));
		line.setColorIndex(new int[]{0,1,2,3,4,5,6,7});
		line.setColorPerVertex(true);
		return line;
	}
	
	/**
	 * ����һ��������
	 * @param degree
	 * @param side1
	 * @param side2
	 * @return
	 */
	public static IndexedLineSet getLineTrigleBySAS(double degree,double side1,double side2){
		IndexedLineSet line = new IndexedLineSet();
		double _degree = VrmlUtils.getDegree(degree);
		double coordinate[][] = new double[3][3];
		
		coordinate[1][0] = side1;

		coordinate[2][0] = side2 * Math.cos(_degree);
		coordinate[2][1] = side2 * Math.sin(_degree);
		
		line.setCoord(new Coordinate(coordinate));
		line.setCoordIndex(new int[]{0,1,-1,1,2,-1,2,0,-1});
		
		line.setColor(ColorGenerator.getSingleColorByType(8, ColorConfig.SOFT_COLOR_BLUE));
		line.setColorIndex(new int[]{0,1,2});
		line.setColorPerVertex(true);
		return line;
	}
	
	/**
	 * ����һ������
	 * @param width ���ο�
	 * @param height ���θ�
	 * @return ������ɵľ���
	 */
	public static IndexedLineSet getLineRectangle(double width,double height){
		IndexedLineSet line = new IndexedLineSet();
		double coordinate[][] = new double[4][3];
		
		coordinate[1][0] = width;

		coordinate[2][0] = width;
		coordinate[2][1] =height;
		
		coordinate[3][1] = height;
		
		line.setCoord(new Coordinate(coordinate));
		line.setCoordIndex(new int[]{0,1,-1,1,2,-1,2,3,-1,3,0,-1});
		
		line.setColor(ColorGenerator.getSingleColorByType(8, ColorConfig.SOFT_COLOR_BLUE));
		line.setColorIndex(new int[]{0,1,2});
		line.setColorPerVertex(true);
		return line;
	}
	
	/**
	 * ����Բ��
	 * @param radius
	 * @param degree
	 * @param degreeStep
	 * @return
	 */
	public static IndexedLineSet getLineArc(double radius,double degree,double degreeStep){
		IndexedLineSet line = new IndexedLineSet();
		double coordinate[][] = new double[(int)Math.ceil(degree/degreeStep)+1][3];
		double _d = 0.0;
		double _v = 0.0;
		for(int i = 0;i<coordinate.length;i++){
			_v = radius * Math.cos(VrmlUtils.getDegree(_d));
			coordinate[i][0] = Math.abs(_v) < 0.0001?0.0:_v;
			_v = radius * Math.sin(VrmlUtils.getDegree(_d));
			coordinate[i][1] = Math.abs(_v) < 0.0001?0.0:_v;
			_d+=degreeStep;
		}
		line.setCoord(new Coordinate(coordinate));
		int []coordindex = new int[3*(coordinate.length-1)];
		for(int i=0,j=0;i < coordinate.length -1&&j < coordindex.length -2;i++,j+=3){
			coordindex[j] = i;
			coordindex[j+1] = i+1;
			coordindex[j+2] = -1;
		}
		line.setCoordIndex(coordindex);
		
		line.setColor(ColorGenerator.getSingleColorByType(coordinate.length, ColorConfig.SOFT_COLOR_BLUE));
		int colorindex[] = new int[coordinate.length];
		for(int i = 0;i<colorindex.length;i++){colorindex[i] =  i;}
		line.setColorIndex(colorindex);
		line.setColorPerVertex(true);
		return line;
	}
	
	/**
	 * ����Բ��
	 * @param radius �뾶
	 * @return ������ɵ�Բ
	 */
	public static IndexedLineSet getLineCircle(double radius){
		return getLineArc(radius,360,12);
	}
	
	public static IndexedLineSet getLineEllipse(double a,double degreeStep){
		return getLineEllipse(new Point3D(),a,degreeStep);
	}
	
	public static IndexedLineSet getLineEllipse(Point3D F1,double a,double degreeStep){
		double _c = Math.abs(F1.getX());
		double _a = a;
		double _b = Math.sqrt((Math.pow(_a, 2) - (Math.pow(_c, 2))));
		
		IndexedLineSet line = new IndexedLineSet();
		double coordinate[][] = new double[(int)Math.ceil(360/degreeStep)+1][3];
		double _d = 0.0;
		double _v = 0.0;
		
		for(int i = 0;i<coordinate.length;i++){
			_v = _a * Math.cos(VrmlUtils.getDegree(_d));
			coordinate[i][0] = Math.abs(_v) < 0.0001?0.0:_v;
			_v = _b * Math.sin(VrmlUtils.getDegree(_d));
			coordinate[i][1] = Math.abs(_v) < 0.0001?0.0:_v;
			_d+=degreeStep;
		}
		line.setCoord(new Coordinate(coordinate));
		int []coordindex = new int[3*(coordinate.length-1)];
		for(int i=0,j=0;i < coordinate.length -1&&j < coordindex.length -2;i++,j+=3){
			coordindex[j] = i;
			coordindex[j+1] = i+1;
			coordindex[j+2] = -1;
		}
		
		line.setCoordIndex(coordindex);
		line.setColor(ColorGenerator.getSingleColorByType(coordinate.length, ColorConfig.SOFT_COLOR_BLUE));
		int colorindex[] = new int[coordinate.length];
		for(int i = 0;i<colorindex.length;i++){colorindex[i] =  i;}
		line.setColorIndex(colorindex);
		line.setColorPerVertex(true);
		return line;
	}
	
}
