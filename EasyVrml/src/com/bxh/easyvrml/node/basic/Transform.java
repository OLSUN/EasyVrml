package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;
/**
 * 	    �ֲ�����ϵ����е�������ϵ���������ͬһ��������ϵ�������ģ�������ϵ��������
 *��ϵȺ�����һ������ʱ��ÿ�����Ͷ����Լ�������ϵ���������е�������ϵ�����������
 *����ͬ�ĸ�����ϵ����λ��
 *	    ������ϵ�����������ϵҲ���и�����ϵ�����Ǹ�����ϵ���Ƕ������е�������ϵ��ͬ
 *�ģ�ÿһ��������ϵ�����Լ��ĸ�����ϵ��������ϵ��������ϵ���Ƕ�ף��γ�һ������ϵ�塣
 *���������ϵ���ÿһ��������ϵ�Ĵ���������������Լ��ĸ����궨λ��
 *	    �ڴ���������ʱ����ҪӦ������任�ĳ��ϣ��ȿ����þֲ�����ϵ��Ҳ�����ö�����ϵ
 *ϵͳ��Ҳ������������ϵ���á���ȫȡ���ڱ�̺ͽ�ģ�ķ��㡣
 *
 * @author BXH
 */
public class Transform implements Node {
	 private double[]       bboxCenter;		  //Χ�����б任�ӽڵ�İ�Χ���������
	
	 private double[]         bboxSize;       //��Χ������ X��Y��Z �����ֵ��ȱʡֵ���ް�Χ������������Լ�ȥ����
	
	 private double[]      translation;		  //����ֵ��������ƽ�Ƶ���λ�ã����۶�����ϵ���Ǿֲ�����ϵϵͳ�������Ķ���������ϵ
	 										  //��ԭ���ڸ�����ϵ�е�λ��
	
	 private double[]         rotation;		  //��������ϵ��ת����ת�����������ת�ĽǶ�,ǰ����������븸����ԭ������߾�����
	 										  //ת�ᣬ���ĸ��������Ի���ֵ��ʾ����ת�ĽǶ�
	 
	 private double[]		     scale;		  //ָ���ظ������������ŵı������������᷽�������ű��ʿ��Բ����
	 
	 private double[] scaleOrientation;       //ָ����ת��������ţ�������������ų߶Ⱥ��ٶ���ѡ�����ת�����������
	
	 private double[]           center;		  //ָ�����ź���ת���������ĵ�
	 
	 private Node[]           children;  	  //ָ���� Transform �ڵ�ĸ��ֱ任Ӱ����ӽڵ���б�������ӽڵ������Ѱ���Ľڵ㣬
	 										  //Ҳ������Ⱥ�ڵ㣬Ҳ���԰��� Transform �ڵ�

	 protected final Map<String,Integer> required;		//��������

	 protected final Map<String,Integer> exsisted;		//�Ѵ�������
	 
	 public final EventIn etranslation;
		
	 public Transform() {
		required = new HashMap<>();
		required.put("children", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("bboxCenter", 1);
		exsisted.put("bboxSize", 1);
		exsisted.put("translation", 1);
		exsisted.put("rotation", 1);
		exsisted.put("scale", 1);
		exsisted.put("scaleOrientation", 1);
		exsisted.put("center", 1);
		exsisted.put("children", 0);
		
		etranslation = new EventIn("translation","SFFloat");
	 }
	 
	public Transform(Node children) {
		this(new double[0],new double[0],new double[]{0,0,0},new double[]{0,0,0,0},new double[0],new double[0],new double[0],new Node[]{children});
	}
	 
	public Transform(Node[] children) {
		this(new double[0],new double[0],new double[0],new double[0],new double[0],new double[0],new double[0],children);
	}
	 
	public Transform(double[] bboxCenter, double[] bboxSize,double[] translation, double[] rotation, double[] scale,
			double[] scaleOrientation, double[] center, Node[] children) {
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		this.translation = translation;
		this.rotation = rotation;
		this.scale = scale;
		this.scaleOrientation = scaleOrientation;
		this.center = center;
		this.children = children;
		
		required = new HashMap<>();
		required.put("children", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("bboxCenter", 1);
		exsisted.put("bboxSize", 1);
		exsisted.put("translation", 1);
		exsisted.put("rotation", 1);
		exsisted.put("scale", 1);
		exsisted.put("scaleOrientation", 1);
		exsisted.put("center", 1);
		exsisted.put("children", 0);
		
		etranslation = new EventIn("translation","SFFloat");
	}

	public double[] getBboxCenter() {
		return bboxCenter;
	}

	public void setBboxCenter(double[] bboxCenter) {
		this.bboxCenter = bboxCenter;
	}

	public double[] getBboxSize() {
		return bboxSize;
	}

	public void setBboxSize(double[] bboxSize) {
		this.bboxSize = bboxSize;
	}

	public double[] getTranslation() {
		return translation;
	}

	public void setTranslation(double[] translation) {
		this.translation = translation;
	}

	public double[] getRotation() {
		return rotation;
	}

	public void setRotation(double[] rotation) {
		this.rotation = rotation;
	}

	public double[] getScale() {
		return scale;
	}

	public void setScale(double[] scale) {
		this.scale = scale;
	}

	public double[] getScaleOrientation() {
		return scaleOrientation;
	}

	public void setScaleOrientation(double[] scaleOrientation) {
		this.scaleOrientation = scaleOrientation;
	}

	public double[] getCenter() {
		return center;
	}

	public void setCenter(double[] center) {
		this.center = center;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public EventIn getEtranslation() {
		return etranslation;
	}
}
