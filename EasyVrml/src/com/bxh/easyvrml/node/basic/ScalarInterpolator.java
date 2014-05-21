package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.exception.FieldLengthException;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;

public class ScalarInterpolator implements Node {
	private double[]		 key;   		//�ؼ�֡��Ӧ��ʱ������б�ͨ������ 0.0 �� 1.0 ֮��ĸ����������� 0.0 �� 1.0
	
	private double[][]	keyValue;  			//�ڲ�����ֵ�б���һ��Ӧ�������ʱ������б��е���ֵ��
	
	protected Map<String, Integer> required; // ��������

	protected Map<String, Integer> exsisted; // �Ѵ�������

	public final EventIn set_fraction; // ���¼�����ֵ�����͡�����ɶ�����ʱ�������

	public final EventOut value_changed; // ���¼�����ֵ�����͡������и�������Ӧ����ɫֵ��
	
	public ScalarInterpolator(double[] key, double[][] keyValue) {
		if(key.length!=keyValue.length){
			throw new FieldLengthException("key ��  keyValue�ĳ���Ӧ����ͬ!");
		}else{
			this.key = key;
			this.keyValue = keyValue;
			required = new HashMap<>();
			required.put("key", 0);
			required.put("keyValue", 0);
			
			exsisted = new HashMap<>();
			exsisted.put("key", 0);
			exsisted.put("keyValue", 0);
			
			this.set_fraction = new EventIn("set_fraction", "SFFloat");
			this.value_changed = new EventOut("value_changed","SFColor");
		}
	}
	public double[] getKey() {
		return key;
	}
	public void setKey(double[] key) {
		this.key = key;
	}
	public double[][] getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(double[][] keyValue) {
		this.keyValue = keyValue;
	}
	public EventIn getSet_fraction() {
		return set_fraction;
	}
	public EventOut getValue_changed() {
		return value_changed;
	}
}
