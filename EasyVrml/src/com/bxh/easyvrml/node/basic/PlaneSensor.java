package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class PlaneSensor implements Node {
	private double[]	minPosition;		//�Ѷ�����ƶ�������ĳһ����Ϸ����ҷ���Ĭ��ֵΪ x=0,y=0
	
	private double[]	maxPosition;		//�Ѷ�����ƶ�������ĳһ����·����󷽡�Ĭ��ֵΪ x=-1,y=-1��
	
	private boolean		    enabled;		//ָʾ��������ǰ�Ƿ���Ӧ����¼�
	
	private double[]		 offset;		//����������ƶ�������ڳ�ʼ�����Զλ�á�
	
	private boolean		 autoOffset;		//����ÿ������϶����ٴ��϶�����ʱ��ʼ��λ��
	
	protected Map<String, Integer> required; // ��������

	protected Map<String,Integer> exsisted;		//�Ѵ�������
	

	public final EventOut 	isActive;	//����¼�������ֵ�����͡���ʾ�����Ƿ񱻰��¡����¼�������ť�����»��ͷ�ʱ�ŷ�
										//�������϶�ʱ�򲻻ᷢ����
	
	public final EventOut 	trackPoint_changed;		//����¼�������ֵ 3 ά�����͡���¼�϶����������� X-Y ƽ���ϵ�ȷ��λ�á��������
													//������ֵ minPosition ��maxPosition �����ơ�
	
	public final EventOut 	translation_changed ;	//����¼�������ֵ 3 ά�����͡���¼�϶��������������� X-Y ƽ���ϵ���ʱλ�á����
													//ʱ��Ҫ����ֵ minPosition �� maxPosition ������
	
	
	public PlaneSensor() {
		this(new double[]{0.0,0.0},new double[]{-1,-1},true,new double[]{0.0,0.0,0.0},true);
	}
	
	public PlaneSensor(double[] minPosition, double[] maxPosition,
			boolean enabled, double[] offset, boolean autoOffset) {
		this.minPosition = minPosition;
		this.maxPosition = maxPosition;
		this.enabled = enabled;
		this.offset = offset;
		this.autoOffset = autoOffset;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("minPosition", 1);
		exsisted.put("maxPosition", 1);
		exsisted.put("enabled", 1);
		exsisted.put("offset", 1);
		exsisted.put("autoOffset", 1);
		
		isActive = new EventOut("isActive","SFBool");
		trackPoint_changed = new EventOut("trackPoint_changed","SFVec3f");
		translation_changed = new EventOut("translation_changed","SFVec3f");
	}
	public double[] getMinPosition() {
		return minPosition;
	}
	public void setMinPosition(double[] minPosition) {
		this.minPosition = minPosition;
	}
	public double[] getMaxPosition() {
		return maxPosition;
	}
	public void setMaxPosition(double[] maxPosition) {
		this.maxPosition = maxPosition;
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

	public EventOut getTranslation_changed() {
		return translation_changed;
	}
}
