package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class TimeSensor implements Node {

	private Long 		cycleInterval;			//ÿ���仯���ڵĳ��ȣ�����Ϊ��λ��ȡֵ���� 0

	private boolean 		  enabled;			//�趨�Ƿ����ʱ����������
	
	private boolean 		     loop;			//����ʱ�䴫����������ѭ����������һ�����ں���ֹ
	
	private Long			startTime;			//��ʼ�����¼���ʱ��
	
	private Long			 stopTime;			//��ֹ�����¼���ʱ�䡣��ֵ��С�ڵ�����ʼʱ�䣬�򱻺���

	
	public final EventOut	cycleTime;			//���¼�����ֵ�����͡�����ʱ�䴫������ǰ�Ƿ������С��������У��򷵻� TRUE������
												//��ֹͣ״̬���򷵻� FALSE ��
	
	public final EventOut 	 isActive;			//���¼�����ֵʱ���͡���ÿ�����ڿ�ʼʱ�����ص�ǰʱ��
	
	public final EventOut fraction_changed;
	
	public final EventOut		 Time;			//���¼�����ֵʱ���͡��Ӹ�������ʱ�� 1970 �� 1 �� 1 ����ʱ����ҹ 12 �㣩������������������
	
	protected Map<String,Integer> required;		//��������

	protected Map<String,Integer> exsisted;		//�Ѵ�������
	
	public TimeSensor(Long cycleInterval) {
		this(cycleInterval,true,true,null,null);
	}
	
	public TimeSensor() {
		this(1L,true,true,null,null);
	}

	public TimeSensor(Long cycleInterval, boolean enabled, boolean loop,Long startTime, Long stopTime) {
		this.cycleInterval = cycleInterval;
		this.enabled = enabled;
		this.loop = loop;
		this.startTime = startTime;
		this.stopTime = stopTime;
		
		required = new HashMap<>();

		exsisted = new HashMap<>();
		exsisted.put("cycleInterval", 1);
		exsisted.put("enabled", 1);
		exsisted.put("loop", 1);
		exsisted.put("startTime", 1);
		exsisted.put("stopTime", 1);
		
		this.cycleTime = new EventOut("cycleTime","SFBool");
		this.isActive  = new EventOut("isActive","SFTime");
		this.fraction_changed = new EventOut("fraction_changed", "SFFloat");
		this.Time = new EventOut("Time","SFTime");
	}

	public Long getCycleInterval() {
		return cycleInterval;
	}

	public void setCycleInterval(Long cycleInterval) {
		this.cycleInterval = cycleInterval;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getStopTime() {
		return stopTime;
	}

	public void setStopTime(Long stopTime) {
		this.stopTime = stopTime;
	}

	public EventOut getCycleTime() {
		return cycleTime;
	}

	public EventOut getIsActive() {
		return isActive;
	}

	public EventOut getFraction_changed() {
		return fraction_changed;
	}

	public EventOut getTime() {
		return Time;
	}
}
