package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class TouchSensor implements Node {

	private boolean		enabled;			//enabled �����˴������Ƿ���û������豸������Ӧ

	protected Map<String, Integer> required; // ��������

	protected Map<String,Integer> exsisted;		//�Ѵ�������
	
	public final EventOut 	isOver;					//���¼�����ֵ�����͡�����¼�ָ����굱ǰ�Ƿ���ָ�ڶ����ϣ�ֻҪ���λ�ڶ�������
												//���Ƿ��в������������϶��ȣ� ���ͻ���� TRUE��������� FALSE 
	
	public final EventOut 	isActive;				//���¼�����ֵ�����͡�ָ�����İ����Ƿ񱻰��£������������ TRUE ���������
												//FALSE ��
	
	public final EventOut 	hitPoint_changed;		//���¼�����ֵ 3 ά�����͡������λ�ڶ�����ʱ�������������������¼���ͬ������
												//��������ͬ����ʱ�������λ�����ꡣ
	
	public final EventOut 	hitNormal_changed;		//���¼�����ֵ 3 ά�����͡�����¼�������� hitPoint_changed ��ָ����ķ�����
	
	public final EventOut 	hitTexCoord_changed;	//���¼�����ֵ 2 ά�����͡�hitPoing_changed ��ָ��������ͱ�����������ꡣ
	
	public final EventOut 	touchTime;				//���¼�����ֵʱ���͡������������ʱ��
	
	public TouchSensor() {
		this(true);
	}

	public TouchSensor(boolean enabled) {
		this.enabled = enabled;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("enabled", 1);
		
		touchTime = new EventOut("touchTime","SFTime");
		hitTexCoord_changed = new EventOut("hitTexCoord_changed","SFVec2f");
		hitNormal_changed = new EventOut("hitNormal_changed","SFVec3f");
		hitPoint_changed = new EventOut("hitPoint_changed","SFVec3f");
		isActive = new EventOut("isActive","SFBool");
		isOver = new EventOut("isOver","SFBool");
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public EventOut getIsOver() {
		return isOver;
	}

	public EventOut getIsActive() {
		return isActive;
	}

	public EventOut getHitPoint_changed() {
		return hitPoint_changed;
	}

	public EventOut getHitNormal_changed() {
		return hitNormal_changed;
	}

	public EventOut getHitTexCoord_changed() {
		return hitTexCoord_changed;
	}

	public EventOut getTouchTime() {
		return touchTime;
	}
}
