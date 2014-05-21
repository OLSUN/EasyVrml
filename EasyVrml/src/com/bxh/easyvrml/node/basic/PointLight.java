package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.impl.Light;
import com.bxh.easyvrml.impl.Node;

public class PointLight implements Light {
	private boolean 	  		 on;		//���ù�Դ�Ĵ򿪺͹رա�
	
	private double 		  intensity; 		//���ù�Դǿ�ȣ��ڳ����о��������˹�Դ������
	
	private double ambientIntensity; 		//���ù�Դ���ڳ�����������Χ�Ļ������Ӱ��̶ȣ�0 ��ʾ����Ӱ�죬�� 1 ��ʾ��ȫ��
											//Ӱ�졣
	
	private double			[]color;		//���ù�Դ����ɫ��Ϊ�ܹ�ʵ��Ԥ��Ĺ���Ч�������뿼�����͵���ɢ����ɫ
	
	private double[]	   location;		//�ֲ�����ϵ�й�Դ��λ�ã���Ҫע����ǣ���Դ������任��Ӱ�죬ͬһ������ϵ�µ���
											//�ͻ��ܵ���Դ��Ӱ�죬����Դ����Ӱ�����������ϵ�е�����
	
	private double			 radius;		//���ù�Դ�����ð뾶�����������ܵ���ԴӰ�����Զ����
	
	private double[]	attenuation;		//���ù�ǿ˥���̶�
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������

	
	public PointLight() {
		this(true,10,1,new double[]{1.0,1.0,1.0},new double[]{0,0,0},100,new double[]{1,0,0});
	}
	
	public PointLight(boolean on,double []color,Point3D location) {
		this(true,10,1,color,new double[]{location.getX(),location.getY(),location.getZ()},100,new double[]{1,0,0});
	}

	public PointLight(boolean on, double intensity, double ambientIntensity,
			double []color, double[] location, double radius, double[] attenuation) {
		this.on = on;
		this.intensity = intensity;
		this.ambientIntensity = ambientIntensity;
		this.color = color;
		this.location = location;
		this.radius = radius;
		this.attenuation = attenuation;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("on", 1);
		exsisted.put("intensity", 1);
		exsisted.put("ambientIntensity", 1);
		exsisted.put("color", 1);
		exsisted.put("location", 1);
		exsisted.put("radius", 2);
		exsisted.put("attenuation", 1);
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public double getAmbientIntensity() {
		return ambientIntensity;
	}

	public void setAmbientIntensity(double ambientIntensity) {
		this.ambientIntensity = ambientIntensity;
	}

	public double[] getColor() {
		return color;
	}

	public void setColor(double []color) {
		this.color = color;
	}

	public double[] getLocation() {
		return location;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double[] getAttenuation() {
		return attenuation;
	}

	public void setAttenuation(double[] attenuation) {
		this.attenuation = attenuation;
	}
}
