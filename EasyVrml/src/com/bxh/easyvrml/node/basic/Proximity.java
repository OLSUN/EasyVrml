package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class Proximity implements Node {
	private double[]		center;			//�����������ģ��ڸ������ڴ���������û�����
	
	private double[]		  size;			//�� center Ϊ���ģ��趨�������ÿ�������᷽�������ֵ���Ӷ�ȷ���������Ĵ�С
	
	private boolean 	   enabled;			//ȷ��������Ƿ�򿪡����Ϊ TRUE����ʾ��������ڼ���û��Ķ���

	protected Map<String, Integer> required; // ��������

	protected Map<String, Integer> exsisted; // �Ѵ�������
		
	public final EventOut isActive;				//����¼�����ֵ�����͡�TRUE ��ʾ�û��Ƿ����������FALSE ��ʾ�뿪������
		
	public final EventOut position_changed;				//����¼���3 ά�����͡�����ߵ�ǰ��λ�ã���������߽�����ڼ����������ƶ�����
												//ʱ�޸ġ�
	
	public final EventOut orientation_changed;				//����¼�����ֵ��ת�͡�����ߵ�ǰ�ķ�λ����������߽�����ڼ����������ƶ�����
												//ʱ�޸�
	
	public final EventOut enterTime;
	
	public final EventOut exitTime;
	
	
	public Proximity() {
		this(new double[]{0.0,0.0,0.0},new double[]{0.0,0.0,0.0},true);
	}

	public Proximity(double[] center, double[] size, boolean enabled) {
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
		position_changed = new EventOut("position_changed","SFVec3f");
		orientation_changed = new EventOut("orientation_changed","SFRotation");
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

	public EventOut getIsActive() {
		return isActive;
	}

	public EventOut getPosition_changed() {
		return position_changed;
	}

	public EventOut getOrientation_changed() {
		return orientation_changed;
	}

	public EventOut getEnterTime() {
		return enterTime;
	}

	public EventOut getExitTime() {
		return exitTime;
	}

}
