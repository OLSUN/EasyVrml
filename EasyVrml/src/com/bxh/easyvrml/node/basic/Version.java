package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Node;

/**
 * Version ���ڱ�ʾDocument�İ汾��Ϣ
 * @author BXH
 */
public class Version implements Node{
	
	private double version_id;		//�汾��
	private String encoding;		//�ַ���
	
	public Version() {
		this(2.0,"utf8");		//Ĭ�ϰ汾��Ϊ2.0 �ַ���ΪUTF-8 
	}

	/**
	 * @param version_id	�汾��
	 * @param encoding	�ĵ�����
	 */
	
	public Version(double version_id, String encoding) {
		this.version_id = version_id;
		this.encoding = encoding;
	}
	
	public double getVersion_id() {
		return version_id;
	}
	
	public void setVersion_id(double version_id) {
		this.version_id = version_id;
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	@Override
	public String toString() {
		return "#VRML V" + version_id + " " + encoding;
	}
}
