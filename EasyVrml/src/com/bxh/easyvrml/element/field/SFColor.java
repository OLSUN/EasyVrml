package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

/**
 * ����ֵ��ɫ��
 * 
 * @author BXH
 */
public class SFColor implements FieldType {

	private double[] sfColorValue;

	public SFColor(double[] sfColorValue) {
		super();
		this.sfColorValue = sfColorValue;
	}

	public double[] getSfColorValue() {
		return sfColorValue;
	}

	public void setSfColorValue(double[] sfColorValue) {
		this.sfColorValue = sfColorValue;
	}

	@Override
	public String getType() {
		return "SFColor";
	}

	@Override
	public Object getValue() {
		return sfColorValue;
	}
	
}
