package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Inline implements Node {

	private String         url;			//ָ��һ�����߶�� VRML �ļ���·������·�������Ǳ��ش����ļ�·����Ҳ������������
											//�� VRML �ļ�
	
	private double[]  bboxCenter;		    //��Χ����ڵ�������ӽڵ�����������
	
	private double[]    bboxSize;			//��Χ����ڵ�������ӽڵ�������� X��Y��Z �����ϵĴ�С��ȱʡֵָ��û�а�Χ����
											//��������Լ�������ʵ�����

	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	
	public Inline(String url) {
		this(url,new double[]{0.0,0.0,0.0},new double[]{-1,-1,-1});
	}

	public Inline(String url, double[] bboxCenter, double[] bboxSize) {
		this.url = url;
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		
		required = new HashMap<>();
		required.put("url", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("url", 1);
		exsisted.put("bboxCenter", 2);
		exsisted.put("bboxSize", 2);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
}
