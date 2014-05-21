package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.tools.ColorConfig;


/**
 * Ԫ�ز��ʽڵ㣬��������Ԫ�صĲ�����Ϣ
 * @author BXH
 */

public class Material implements Node {
	
	//��������ɫ
	private double diffuseColor[];
	
	//���徵�淴������ɫ
	private double specularColor[];
	
	//�����ⱻ������淴��ĳ̶�
	private double ambientIntensity;
	
	//������������
	private double shininess;
	
	//��������ķ�������ɫ
	private double emissiveColor[];
	
	//�����͸���� ��0��ʾ��͸��,1.0��ʾȫ͸����
	private double transparency;

	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public final EventIn ediffuseColor;
	
	public Material(){
		this(ColorConfig.DEFAULT_COLOR);		//����ΪĬ�ϵĲ���
	}
	
	public Material(int materialType){
		switch(materialType){
			case ColorConfig.SOFT_COLOR_RED:
				diffuseColor = new double[]{ .88, .15, .01};
				specularColor = new double[]{ .19, .03, .03};
				ambientIntensity =  .0833;
				shininess = .08;
				break;
			case ColorConfig.SOFT_COLOR_PINK:
				diffuseColor = new double[]{1, .45, .4};
				specularColor = new double[]{.69, .4, .42};
				ambientIntensity =0.153;
				shininess = 0.9;
				break;
			case ColorConfig.SOFT_COLOR_GREEN:
				diffuseColor = new double[]{.32,.54,.26};
				specularColor = new double[]{.46,.46,.46};
				ambientIntensity =.0933;
				shininess = .51;
				break;
			case ColorConfig.SOFT_COLOR_BLUE:
				diffuseColor = new double[]{.33,.34,.6};
				specularColor = new double[]{.29,.29,.29};
				ambientIntensity =.103;
				shininess = .79;
				break;
			case ColorConfig.SOFT_COLOR_YELLOW:
				diffuseColor = new double[]{1, .85, 0};
				specularColor = new double[]{.87, .25 ,.25};
				ambientIntensity =.157;
				shininess = 1;
				break;
			case ColorConfig.NEON_COLOR_YELLOW:
				diffuseColor = new double[]{0,0,0};
				specularColor = new double[]{1, 1, 1};
				emissiveColor = new double[]{1, .82 ,0};
				ambientIntensity = 0;
				shininess = .05;
				break;
			case ColorConfig.DEFAULT_COLOR:
			default:
				diffuseColor = new double[]{.61, .61, .61};
				specularColor = new double[]{.77, .76, .76};
				ambientIntensity =0.14;
				shininess = 0.9;
				transparency = 0.0;
				break;
		}
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("diffuseColor", 1);
		exsisted.put("specularColor", 1);
		exsisted.put("ambientIntensity", 1);
		exsisted.put("shininess", 1);
		exsisted.put("emissiveColor", 1);
		exsisted.put("transparency", 1);
		
		this.ediffuseColor = new EventIn("diffuseColor","SFFloat");
	}
	
	public Material(double []diffuseColor,double []specularColor,double []emissiveColor,double ambientIntensity,double shininess){
		this.diffuseColor = diffuseColor;
		this.specularColor = specularColor;
		this.ambientIntensity = ambientIntensity;
		this.shininess = shininess;
		this.emissiveColor = emissiveColor;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("diffuseColor", 1);
		exsisted.put("specularColor", 1);
		exsisted.put("ambientIntensity", 1);
		exsisted.put("shininess", 1);
		exsisted.put("emissiveColor", 1);
		exsisted.put("transparency", 2);
		
		this.ediffuseColor = new EventIn("diffuseColor","SFFloat");
	}

	public double[] getDiffuseColor() {
		return diffuseColor;
	}

	public void setDiffuseColor(double[] diffuseColor) {
		this.diffuseColor = diffuseColor;
	}

	public double[] getSpecularColor() {
		return specularColor;
	}

	public void setSpecularColor(double[] specularColor) {
		this.specularColor = specularColor;
	}

	public double getAmbientIntensity() {
		return ambientIntensity;
	}

	public void setAmbientIntensity(double ambientIntensity) {
		this.ambientIntensity = ambientIntensity;
	}

	public double getShininess() {
		return shininess;
	}

	public void setShininess(double shininess) {
		this.shininess = shininess;
	}

	public double[] getEmissiveColor() {
		return emissiveColor;
	}

	public void setEmissiveColor(double[] emissiveColor) {
		this.emissiveColor = emissiveColor;
	}

	public double getTransparency() {
		return transparency;
	}

	public void setTransparency(double transparency) {
		this.transparency = transparency;
	}

	public EventIn getEdiffuseColor() {
		return ediffuseColor;
	}
}
