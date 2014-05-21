package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class VisibilitySensor implements Node {
	private double[] 		center;    	//����ô������Ŀɼ������ļ�������
	
	private double[]		  size;		//����ô������Ŀɼ�������� X��Y��Z ����Ĵ�С
	
	private boolean		   enabled;		//ȷ�� VisibilitySensor �Ƿ��ڼ���״̬��
	
	protected Map<String, Integer> required; // ��������

	protected Map<String, Integer> exsisted; // �Ѵ�������
	
	public final EventOut isActive;				//����¼�����ֵ�����͡�TRUE �����û��ѽ���ɼ������FALSE �����û����ڸ���
												//���ڡ�
	
	public final EventOut enterTime;			//����¼�����ֵʱ���͡�����ɼ������ʱ�䡣
	
	public final EventOut exitTime;				//����¼�����ֵʱ���͡��뿪�ɼ������ʱ��
	
	public VisibilitySensor() {
		this(new double[]{0.0,0.0,0.0},new double[]{0.0,0.0,0.0},true);
	}

	public VisibilitySensor(double[] center, double[] size, boolean enabled) {
		super();
		this.center = center;
		this.size = size;
		this.enabled = enabled;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("center", 1);
		exsisted.put("size", 1);
		exsisted.put("enabled", 1);
		
		isActive = new EventOut("isActive","SFBool");
		enterTime = new EventOut("enterTime","SFTime");
		exitTime = new EventOut("exitTime","SFTime");
	}
	
	public double[] getCenter() {
		return center;
	}
	public void setCenter(double[] center) {
		this.center = center;
	}
	public double[] getSize() {
		return size;
	}
	public void setSize(double[] size) {
		this.size = size;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
