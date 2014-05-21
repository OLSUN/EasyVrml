package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.tools.VrmlUtils;

public class SpotLight implements Node {
	private boolean				 on;			//���ù�Դ�򿪻��ǹرգ��������Ϊ FALSE �رչ�Դ����Գ�����û�й�������
	
	private double	 	  intensity;			//���ù�Դ��ǿ�ȣ�Ҳ���ǹ�Դ������
	
	private double ambientIntensity; 			//���ù�Դ���ڳ�����������Χ�Ļ������Ӱ��̶ȣ�0 ��ʾ����Ӱ�죬�� 1 ��ʾ��ȫ��
												//Ӱ��
	
	private double			[]color;			//���ù�Դ����ɫ��Ϊ�ܹ�ʵ��Ԥ��Ĺ���Ч�������뿼�����͵���ɢ����ɫ��
	
	private double[]	   location;			//���ù�Դ���ڵ�λ�����꣬��Բ׶�Ķ��㡣
	
	private double[]	  direction;			//���ù����γɵ�Բ׶�����ߵķ���
	
	private double		  beamWidth;			//���ù���ɢ��ĽǶȣ��Ի���Ϊ��λ�� �������ɢ����ڣ����ǿ��һ�¡�����ɢ��ǹ�
												//ǿ�𽥼������ڹ�Դ���ڵ��ǵ�׶�洦��Ϊ��
	
	private double		cutOffAngle;			//���ù�Դ���ڵ��ǣ��ȹ���Բ׶���׶�ǣ�ֻ��λ�ڸ�ɢ��Ƿ�Χ�ڵ����������ܹ���
												//���䵽
	
	private double			 radius;			//���ù�Դ��������
	
	private double[]	attenuation;			//���ù�Դǿ�ȵ�˥���̶�
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public SpotLight() {
		this(true,1,1,new double[]{1,0,0},new double[]{0,0,0},new double[]{1,0,0},VrmlUtils.getDegree(10),VrmlUtils.getDegree(45),100,new double[]{1,0,0});
	}
	
	public SpotLight(boolean on,double []location,double []color,double []direction) {
		this(on,1,1,color,location,direction,1.570796,0.785398,100,new double[]{1,0,0});
	}

	public SpotLight(boolean on, double intensity, double ambientIntensity,double []color, double[] location, double[] direction,
			double beamWidth, double cutOffAngle, double radius,double[] attenuation) {
		this.on = on;
		this.intensity = intensity;
		this.ambientIntensity = ambientIntensity;
		this.color = color;
		this.location = location;
		this.direction = direction;
		this.beamWidth = beamWidth;
		this.cutOffAngle = cutOffAngle;
		this.radius = radius;
		this.attenuation = attenuation;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("on", 1);
		exsisted.put("intensity", 1);
		exsisted.put("ambientIntensity", 1);
		exsisted.put("color", 1);
		exsisted.put("location", 1);
		exsisted.put("direction", 1);
		exsisted.put("beamWidth", 1);
		exsisted.put("cutOffAngle", 1);
		exsisted.put("radius", 1);
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
	public double[] getDirection() {
		return direction;
	}
	public void setDirection(double[] direction) {
		this.direction = direction;
	}
	public double getBeamWidth() {
		return beamWidth;
	}
	public void setBeamWidth(double beamWidth) {
		this.beamWidth = beamWidth;
	}
	public double getCutOffAngle() {
		return cutOffAngle;
	}
	public void setCutOffAngle(double cutOffAngle) {
		this.cutOffAngle = cutOffAngle;
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
