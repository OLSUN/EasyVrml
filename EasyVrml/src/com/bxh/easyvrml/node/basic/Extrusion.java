package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;

public class Extrusion implements Geometry {
	
	private double[][] 		  spine;			//����ʵ���϶�����һ���ؼ�ѹ�����ϵ������ߣ�ͨ��Ϊ��������
	
	private double[][] crossSection;			//��һϵ�ж�ά����������������ڵ������������һ����ά���ߣ���Ϊ��
												//ѹ�����е��ⲿ����
	
	private double[] 		  scale;			//��������ά���ߵĳ߶��� spine ��ѹ���������ű任����
	
	private double[][]  orientation;			//��������ά��ת�任������һ�����ֵ�ĸ����� spine ��һ����˳���Ӧ��ÿ�����ǹ�
												//��㴦�Ķ�ά���ߵ���ת�任
	
	private boolean 	   beginCap;			//����ȷ����ѹ���͵������Ƿ�����ʼ���棨��Ӧ spine �ĵ�һ��ֵ������� beginCap ����
												//ΪFALSE ���򲻲�����ʼ���棬������ʼ�����ǽ� crossSection ���еĶ�ά������β������
												//�ɵĶ���α���
	
	private boolean 		 endCap;			//����ȷ����ѹ���͵������Ƿ�����ֹ���棨��Ӧ spine �����һ��ֵ��
	
	private boolean 			ccw;			//Extrusion �ڵ��Զ����ɼ�����ķ��ߣ�����������߷������ά��������Ĺ�ϵ
	
	private boolean 		  solid;			//����һ����������棬���߷���ı��汻��Ϊ�ǡ��⡱���棬����෴���ǡ��ڡ����棬
												//�� solid ��Ϊ TRUE ʱ��ֻ��ʾ���⡱���棬���ڡ����沢����ʾ��ɫ
	
	private boolean 		 convex;			//����ȷ����ѹ���͵ļ��������ʼ����ͽ���������͹���ǰ��¡������ֵΪ TRUE��
												//�������͹��ģ��������ʾ����Ϊ���µ�
	
	private double 		creaseAngle; 			//����ȷ��һ���Ƕȡ�����������Լ��������ڱ���֮����Ĵ���������ڱ��淨��֮��
												//�ļнǵľ���ֵС����һ�Ƕȣ�����������ڱ�����ƽ����������Բ���ģ����ܱ����Եز�
												//����
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	
	public Extrusion(double[][] spine,double[][] crossSection){
		this(spine,crossSection,new double[0],new double[0][0],false,false,false,false,false,0.785);
	}
	
	public Extrusion(double[][] spine, double[][] crossSection, double[] scale,
			double[][] orientation, boolean beginCap, boolean endCap,
			boolean ccw, boolean solid, boolean convex, double creaseAngle) {
		this.spine = spine;
		this.crossSection = crossSection;
		this.scale = scale;
		this.orientation = orientation;
		this.beginCap = beginCap;
		this.endCap = endCap;
		this.ccw = ccw;
		this.solid = solid;
		this.convex = convex;
		this.creaseAngle = creaseAngle;
		
		required = new HashMap<>();
		required.put("spine", 0);
		required.put("crossSection", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("spine", 0);
		exsisted.put("crossSection", 0);
		exsisted.put("scale", 1);
		exsisted.put("orientation", 1);
		exsisted.put("beginCap", 1);
		exsisted.put("endCap", 1);
		exsisted.put("ccw", 1);
		exsisted.put("solid", 1);
		exsisted.put("convex", 1);
		exsisted.put("creaseAngle", 1);
	}
	
	public double[][] getSpine() {
		return spine;
	}
	public void setSpine(double[][] spine) {
		this.spine = spine;
	}
	public double[][] getCrossSection() {
		return crossSection;
	}
	public void setCrossSection(double[][] crossSection) {
		this.crossSection = crossSection;
	}
	public double[] getScale() {
		return scale;
	}
	public void setScale(double[] scale) {
		this.scale = scale;
	}
	public double[][] getOrientation() {
		return orientation;
	}
	public void setOrientation(double[][] orientation) {
		this.orientation = orientation;
	}
	public boolean isBeginCap() {
		return beginCap;
	}
	public void setBeginCap(boolean beginCap) {
		this.beginCap = beginCap;
	}
	public boolean isEndCap() {
		return endCap;
	}
	public void setEndCap(boolean endCap) {
		this.endCap = endCap;
	}
	public boolean isCcw() {
		return ccw;
	}
	public void setCcw(boolean ccw) {
		this.ccw = ccw;
	}
	public boolean isSolid() {
		return solid;
	}
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
	public boolean isConvex() {
		return convex;
	}
	public void setConvex(boolean convex) {
		this.convex = convex;
	}
	public double getCreaseAngle() {
		return creaseAngle;
	}
	public void setCreaseAngle(double creaseAngle) {
		this.creaseAngle = creaseAngle;
	}
}
