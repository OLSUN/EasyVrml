package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class FontStyle implements Node {
	
	private double size;				//�����ı������з���ȷ��ÿ��ˮƽ���ֵĸ߶ȣ���ÿ�д�ֱ���ֵĿ�ȣ�Ĭ��ֵΪ 1.0
	
	private String family;				//ָ��������������һ�����壬��������ѡ��Serif �����塢Sans ������� Typewriter ����
										//��
	
	private String style;				//����ָ�������ǳ������塢���塢б����б�塣�մ���ʾ�������塣
	
	private boolean horizontal;			//��ʾ���ֵķ���ѡ�� TRUE ��ʾˮƽ���ַ���ѡ�� FALSE ��ʾ��ֱ���ַ���
	
	private boolean leftToRight;		//��ʾ���ֶ�ȡ�ķ���ѡ�� TRUE �Ǵ������Ҷ���ѡ�� FALSE ��ʾ�����������
	
	private boolean topToBottom;		//������ leftToRight������������ʾ��ֱ�������е����ֵĶ�ȡ����
	
	private String language;			//ʹ�õ�����
	
	private String[] justify;			//��һ����ֵ��ʾ����������롢���ж��룬�����Ҷ��롣���磺���ڴ������ҵ�ˮƽ���֣�
										//"BEGIN" ��ʾ����룬"MIDDLK" ��ʾ���ж��룬"END"   ��ʾ�Ҷ��롣�ڶ�����ֵ��ʾ�ڴη�
										//������ζ������ֿ顣����ڶ�����ֵδ�趨��ȡȱʡֵ"FIRST" ��
	private double spacing;				//��ʾ�м�ࡣ1 ��ʾ���м�࣬�м����Ϊ 1 �� size ��λ��2 ��ʾ˫�м�࣬�൱�����
										//����һ�����С�
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public FontStyle(double size){
		this(size,"","",true,true,true,"en",new String[]{"BEGIN","FIRST"},1.0);
	}
	
	public FontStyle(){
		this(1.0,"","",true,true,true,"en",new String[]{"BEGIN","FIRST"},1.0);
	}
	
	public FontStyle(double size,String family,String style,boolean horizontal,boolean leftToRight,boolean topToBottom,String language,String []justify,double spacing){
		this.size = size;
		this.family = family;
		this.style = style;
		this.horizontal = horizontal;
		this.leftToRight = leftToRight;
		this.language = language;
		this.topToBottom = topToBottom;
		this.justify = justify;
		this.spacing = spacing;
		
		required = new HashMap<>();

		exsisted = new HashMap<>();
		exsisted.put("size", 1);
		exsisted.put("family", 1);
		exsisted.put("style", 1);
		exsisted.put("horizontal", 1);
		exsisted.put("leftToRight", 1);
		exsisted.put("language", 1);
		exsisted.put("topToBottom", 1);
		exsisted.put("justify", 1);
		exsisted.put("spacing", 1);
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean isLeftToRight() {
		return leftToRight;
	}

	public void setLeftToRight(boolean leftToRight) {
		this.leftToRight = leftToRight;
	}

	public boolean isTopToBottom() {
		return topToBottom;
	}

	public void setTopToBottom(boolean topToBottom) {
		this.topToBottom = topToBottom;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String[] getJustify() {
		return justify;
	}

	public void setJustify(String[] justify) {
		this.justify = justify;
	}

	public double getSpacing() {
		return spacing;
	}

	public void setSpacing(double spacing) {
		this.spacing = spacing;
	}
	
}
