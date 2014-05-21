package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Background implements Node {
	private double[][]	groundColor;		//����ָ��������������ɫ�� RGB ֵ�������趨һϵ�е���ɫֵ�Ա��γɰ�ˮƽ�ֲ㽥��
											//��Ч�����������г��ĵ�һ����ɫֵ��ָ��ֱ���¿������Ǹ������ɫ
	
	private double[]	groundAngle;		//ָ��һϵ���Ի��ȱ�ʾ�ĽǶ�ֵ����Щ�Ƕ�ֵ��Ӧ���� groundColor ���ڸ�����һϵ����
											//ɫֵ
	
	private double[][]	   skyColor;		//����ָ�����������ɫ�� RGB ֵ�������趨һϵ�е���ɫֵ�Ա��γɰ�ˮƽ�ֲ㽥���
											//Ч�������г��ĵ�һ��ֵ�Ƕ�Ӧ��ֱ���Ͽ���һ�����ɫ
	
	private double[]       skyAngle;		//ָ��һϵ���Ի��ȱ�ʾ�ĽǶ�ֵ�� ��Щ�Ƕ�ֵ��Ӧ���� skyColor ���ڸ�����һϵ����ɫֵ
	
	private String[]	   frontUrl;		//�ֱ�ָ������ӳ�䵽�ռ�������������ϵ�ͼ���·��������ӱ���ͼƬ
	
	private String[]	    backUrl;		
	
	private String[]       rightUrl;		
	
	private String[]		leftUrl;		
	
	private String[]		 topUrl;		
	
	private String[]	  bottomUrl;		
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	
	public Background() {
//		this(new double[][]{{1.0,1.0,1.0}},
//			 new double[]{1.309,1.571},
//			 new double[][]{{1.0,1.0,1.0}},
//			 new double[]{1.309,1.571},
//			 new String[0],
//			 new String[0],
//			 new String[0],
//			 new String[0],
//			 new String[0],
//			 new String[0]);
		this(new double[][]{{0.0,0.2,0.7},
							{0.0,0.5,1.0},
							{1.0,1.0,1.0}},
			 new double[]{1.309,1.571},
			 new double[][]{
				{0.1,0.15,0.0},
				{0.4,0.25,0.2},
				{0.5,0.55,0.5}},
			 new double[]{1.309,1.571},
			 new String[0],
			 new String[0],
			 new String[0],
			 new String[0],
			 new String[0],
			 new String[0]);
	}

	public Background(double[][] groundColor, double[] groundAngle,double[][] skyColor, double []skyAngle, String[] frontUrl,
			String[] backUrl, String[] rightUrl, String[] leftUrl,String[] topUrl, String[] bottomUrl) {
		this.groundColor = groundColor;
		this.groundAngle = groundAngle;
		this.skyColor = skyColor;
		this.skyAngle = skyAngle;
		this.frontUrl = frontUrl;
		this.backUrl = backUrl;
		this.rightUrl = rightUrl;
		this.leftUrl = leftUrl;
		this.topUrl = topUrl;
		this.bottomUrl = bottomUrl;
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("groundColor", 1);
		exsisted.put("groundAngle", 1);
		exsisted.put("skyColor", 1);
		exsisted.put("skyAngle", 1);
		exsisted.put("frontUrl", 1);
		exsisted.put("backUrl", 1);
		exsisted.put("rightUrl", 1);
		exsisted.put("leftUrl", 1);
		exsisted.put("topUrl", 1);
	}
	
	public double[][] getGroundColor() {
		return groundColor;
	}
	public void setGroundColor(double[][] groundColor) {
		this.groundColor = groundColor;
	}
	public double[] getGroundAngle() {
		return groundAngle;
	}
	public void setGroundAngle(double[] groundAngle) {
		this.groundAngle = groundAngle;
	}
	public double[][] getSkyColor() {
		return skyColor;
	}
	public void setSkyColor(double[][] skyColor) {
		this.skyColor = skyColor;
	}
	public double[] getSkyAngle() {
		return skyAngle;
	}
	public void setSkyAngle(double[] skyAngle) {
		this.skyAngle = skyAngle;
	}
	public String[] getFrontUrl() {
		return frontUrl;
	}
	public void setFrontUrl(String[] frontUrl) {
		this.frontUrl = frontUrl;
	}
	public String[] getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String[] backUrl) {
		this.backUrl = backUrl;
	}
	public String[] getRightUrl() {
		return rightUrl;
	}
	public void setRightUrl(String[] rightUrl) {
		this.rightUrl = rightUrl;
	}
	public String[] getLeftUrl() {
		return leftUrl;
	}
	public void setLeftUrl(String[] leftUrl) {
		this.leftUrl = leftUrl;
	}
	public String[] getTopUrl() {
		return topUrl;
	}
	public void setTopUrl(String[] topUrl) {
		this.topUrl = topUrl;
	}
	public String[] getBottomUrl() {
		return bottomUrl;
	}
	public void setBottomUrl(String[] bottomUrl) {
		this.bottomUrl = bottomUrl;
	}
	
}
