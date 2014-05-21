package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class SphereSensor implements Node {
	private boolean 	enabled;		//ȷ��������Ƿ�򿪡�TRUE ��ʾ������Ǵ򿪵ġ�
	
	private double[]	 offset;		//����ÿ���϶�����������ڳ�ʼλ�õ���ת�Ƕ�
	
	private boolean	 autoOffset;		//�൱���Զ����� off set�����ֵΪ TRUE����ʾ���϶�����ʱ������ǰ�ķ�λֵ�洢�� offset
										//�У����Ҷ���ͣ�ڸ÷�λ����ֵΪ FALSE �����û�ÿ�ο�ʼһ���µ��϶�ʱ�������帴λ����
										//ʼֵ��

	protected Map<String, Integer> required; // ��������

	protected Map<String, Integer> exsisted; // �Ѵ�������
	 
	public final EventOut isActive; 				// ���¼�����ֵ�����͡�ȷ���û��Ƿ������϶������Ķ������ǣ���� TRUE �¼��� 

	public final EventOut trackPoint_changed; 		// ���¼�����ֵ 3 ά�����͡��϶����Ĺ����У�������ָ���ڰ���Բ��������λ�á�

	public final EventOut rotation_changed ;		//���¼�����ֵ��ת�͡��϶����Ĺ����У�������ָ���ڰ���Բ�������ķ�λ
	
	public SphereSensor() {
		this(true,new double[]{0.0,1.0,0.0,0.0},true);
	}
	
	public SphereSensor(boolean enabled,double[] offset,boolean autoOffset) {
		this.enabled = enabled;
		this.offset = offset;
		this.autoOffset = autoOffset;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("enabled", 1);
		exsisted.put("offset", 1);
		exsisted.put("autoOffset", 1);
		
		isActive = new EventOut("isActive","SFBool");
		trackPoint_changed = new EventOut("trackPoint_changed","SFVec3f");
		rotation_changed = new EventOut("rotation_changed","SFRotation");
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public double[] getOffset() {
		return offset;
	}

	public void setOffset(double[] offset) {
		this.offset = offset;
	}

	public boolean isAutoOffset() {
		return autoOffset;
	}

	public void setAutoOffset(boolean autoOffset) {
		this.autoOffset = autoOffset;
	}

	public EventOut getIsActive() {
		return isActive;
	}

	public EventOut getTrackPoint_changed() {
		return trackPoint_changed;
	}

	public EventOut getRotation_changed() {
		return rotation_changed;
	}
	
}
