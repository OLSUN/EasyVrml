package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;

public class Fog implements Node {

    private String 		 fogType;		//���Ź۲��߾�������ӣ����Ũ�ȷ����仯����ֵ����ȡ"LINEAR" ��"EXPONENTAL" ��
    									//�༴�����α仯����ָ���仯��ʵ���ϸ���ȷ�������ӵ�����
    
    private double visibilityRange;    	//�۲����������п����������͵������롣0 ��С�� 0 ��ֵ��ʾû����
    
    private double		   []color;	    //�����ɫ
    
    protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public final EventIn set_bind;		//���¼�����ֵ�����͡�ͨ���ⲿ�¼���������ʹ Fog �ڵ��ɵ�ǰ��ʹ�õĽڵ㡣
	
	public final EventOut isBound;		//���¼�����ֵ�����͡�����Ŀǰ Fog �ڵ��Ƿ񱻼���类��������� TRUE
	  
	public Fog() {
		this("LINEAR",10,new double[]{1.0,1.0,1.0});
	}

	public Fog(String fogType, double visibilityRange, double []color) {
		this.fogType = fogType;
		this.visibilityRange = visibilityRange;
		this.color = color;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("fogType", 1);
		exsisted.put("visibilityRange", 1);
		exsisted.put("color", 1);
		
		this.set_bind = new EventIn("set_bind","SFBool");
		this.isBound = new EventOut("isBound","SFBool");
	}
	
	public String getFogType() {
		return fogType;
	}
	public void setFogType(String fogType) {
		this.fogType = fogType;
	}
	public double getVisibilityRange() {
		return visibilityRange;
	}
	public void setVisibilityRange(double visibilityRange) {
		this.visibilityRange = visibilityRange;
	}
	public double[] getColor() {
		return color;
	}
	public void setColor(double []color) {
		this.color = color;
	}
	  
}
