package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;

public class Text implements Geometry {

	private String []string;		//�ı�����
	private double []length;		//���õ����ı����ĳ��ȣ�0 ��ʾ����Ϊ���ⳤ�ȡ�������Ƕ�ֵ�ģ�ֵ�ĸ���ȡ��������
									//���ַ����ĸ�����ÿ�����ζ�Ӧ string ���ÿ���ַ����ĳ��ȡ�
	
	private double maxExtent;		//ȷ���ı�������һ������Ҫ�����ϵ����Χ�� ��ֵ������ڵ��� 0�� ��Ҫ������ FontStyle
									//�ڵ�� hori zonal ����ȷ�����������ֵ�� TRUE������Ҫ������ˮƽ���򣬷����Ǵ�ֱ����
									//MaxExtent ��ֵ��Ĭ��ֵΪ 0����ʾ�ַ�����Ϊ���ⳤ�ȡ�
	
	private FontStyle fontStyle;	//�����ַ���������ı�����
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public Text(String []string){
		this(string,new double[string.length],0.0,new FontStyle());
	}
	
	public Text(String []string,double []length,double maxExtent,FontStyle fontStyle){
		this.string = string;
		this.length = length;
		this.maxExtent = maxExtent;
		this.fontStyle = fontStyle;
		
		required = new HashMap<>();
		required.put("string", 0);

		exsisted = new HashMap<>();
		exsisted.put("string", 0);
		exsisted.put("length", 1);
		exsisted.put("maxExtent", 1);
		exsisted.put("fontStyle", 1);
	}

	public String[] getString() {
		return string;
	}

	public void setString(String[] string) {
		this.string = string;
	}

	public double[] getLength() {
		return length;
	}

	public void setLength(double[] length) {
		this.length = length;
	}

	public double getMaxExtent() {
		return maxExtent;
	}

	public void setMaxExtent(double maxExtent) {
		this.maxExtent = maxExtent;
	}

	public FontStyle getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(FontStyle fontStyle) {
		this.fontStyle = fontStyle;
	}
	
}
