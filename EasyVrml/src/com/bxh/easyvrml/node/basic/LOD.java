package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class LOD implements Node {
	private double[]	range;			//����һϵ�еĴӹ۲��ߵ�Ҫ��ʾ����ľ��룬��Щ����ֱ��ӦҪ��ʾ�Ĳ�ͬϸ�ڵĲ�
										//��
	
	private double[]   center; 			//ָ�� LOD �ڵ���ӽڵ�ļ����������ڵ�λ�ã����λ������ȷ���û�������֮��ľ���
	
	private Node[]		level;			//����һ���ӽڵ㣬���ӽڵ�ֱ�����˲�ͬϸ�ڲ�εĶ�Ӧ���ͻ򳡾��������Ǵ����ϸ
										//�ڲ�ε����ϸ�ڲ�Σ�������ֵ�� range ���ֵ������أ�����ϸ��ζ�Ӧ������̵ľ�
										//��
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public LOD(Node[] level) {
		this(new double[]{15,20},new double[]{0,0,0},level);
	}
	
	public LOD(double[] range, double[] center, Node[] level) {
		this.range = range;
		this.center = center;
		this.level = level;
		
		required = new HashMap<>();
		required.put("level", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("level", 0);
		exsisted.put("center", 1);
		exsisted.put("range", 1);
	}

	public double[] getRange() {
		return range;
	}

	public void setRange(double[] range) {
		this.range = range;
	}

	public double[] getCenter() {
		return center;
	}

	public void setCenter(double[] center) {
		this.center = center;
	}

	public Node[] getLevel() {
		return level;
	}

	public void setLevel(Node[] level) {
		this.level = level;
	}
	
}
