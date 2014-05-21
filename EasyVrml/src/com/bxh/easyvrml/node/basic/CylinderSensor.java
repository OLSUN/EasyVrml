package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class CylinderSensor implements Node {
	 private double 	minAngle;		//�϶�������ת���������С�Ƕȡ�
	 
	 private double		maxAngle;		//�϶�������ת���������С�Ƕȡ�����ֵͬ minAngle ��ֵ����ͨ���¼�����ӿ�����
	 									//���á�
	
	 private boolean	  enable;		//ָ��������Ƿ���Ч��TRUE ����������򿪣�FALSE ����������ر�
	 
	 private double	   diskAngle;		//���������������ת��Ϊ����һ��Բ��������Բ���� Y ����ת
	 
	 private double		   offse;		//���õ�ÿ���϶����ʱ����ת���ĽǶ�ֵ��
	 
	 private boolean  autoOffset;		//ȷ���û�ÿ���϶�������ת�ĽǶȣ����Ҷ���ͣ���·�λ
	 
	 
	 protected Map<String, Integer> required; 		// ��������

	 protected Map<String,Integer> exsisted;		//�Ѵ�������
	 
	public final EventOut isActive; 				// ���¼�����ֵ�����͡�ȷ���û��Ƿ������϶������Ķ������ǣ���� TRUE �¼��� 

	public final EventOut trackPoint_changed; 		// ���¼�����ֵ 3 ά�����͡��϶����Ĺ����У�������ָ���ڰ���Բ��������λ�á�

	public final EventOut rotation_changed ;		//���¼�����ֵ��ת�͡��϶����Ĺ����У�������ָ���ڰ���Բ�������ķ�λ
		
	public CylinderSensor() {
		this(0,-1,true,0.262,0,true);
	}
	
	public CylinderSensor(double minAngle, double maxAngle, boolean enable,
			double diskAngle, double offse, boolean autoOffset) {
		this.minAngle = minAngle;
		this.maxAngle = maxAngle;
		this.enable = enable;
		this.diskAngle = diskAngle;
		this.offse = offse;
		this.autoOffset = autoOffset;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("minAngle", 1);
		exsisted.put("maxAngle", 1);
		exsisted.put("enabled", 1);
		exsisted.put("diskAngle", 1);
		exsisted.put("offse", 1);
		exsisted.put("autoOffset", 1);
		
		isActive = new EventOut("isActive","SFBool");
		trackPoint_changed = new EventOut("trackPoint_changed","SFVec3f");
		rotation_changed = new EventOut("rotation_changed","SFRotation");
	}
	
	public double getMinAngle() {
		return minAngle;
	}
	public void setMinAngle(double minAngle) {
		this.minAngle = minAngle;
	}
	public double getMaxAngle() {
		return maxAngle;
	}
	public void setMaxAngle(double maxAngle) {
		this.maxAngle = maxAngle;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public double getDiskAngle() {
		return diskAngle;
	}
	public void setDiskAngle(double diskAngle) {
		this.diskAngle = diskAngle;
	}
	public double getOffse() {
		return offse;
	}
	public void setOffse(double offse) {
		this.offse = offse;
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
