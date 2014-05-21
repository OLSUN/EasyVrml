package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Texture;

public class MovieTexture implements Texture {
	 private String    url;		//ָ����Ϊ�������Ƶ�ļ���·��,��Ƶ����֧�� MPEG ��ʽ�� �ļ�
	
	 private double    speed;		//ָ��ӳ�䵽�����ϵ���Ƶ����Ĳ����ٶȣ������ֵ��һ����������,��ֵ 1 ��ʾ�������ٶȲ��ţ����� 1 ��ʾ���ٲ��ţ�С�� 1 ��ʾ���ٲ��ţ��� ��ֵ��ʾ����
	 
	 private boolean    loop;		//ָ����Ƶ�����Ƿ�ѭ������
	 
	 private int  startTime;    	//ָ����Ƶ����ʼ���ŵ�ʱ��
	 
	 private int   stopTime;  		//ָ����Ƶ����ֹͣ���ŵ�ʱ��
	 
	 private boolean repeatS;		//�����ֵָ������������ S �����ϵ�����ӳ���Ƿ���ظ����������������͵ı���
	 
	 private boolean repeatT;		//�����ֵָ������������ T �����ϵ�����ӳ���Ƿ� ���ظ����������������͵ı���
	 
	 public MovieTexture(String url){
		 this(url,1.0,true,0,0,false,false);
	 }
	 
	public MovieTexture(String url, double speed, boolean loop,int startTime, int stopTime, boolean repeatS, boolean repeatT) {
		this.url = url;
		this.speed = speed;
		this.loop = loop;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.repeatS = repeatS;
		this.repeatT = repeatT;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public boolean isLoop() {
		return loop;
	}
	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getStopTime() {
		return stopTime;
	}
	public void setStopTime(int stopTime) {
		this.stopTime = stopTime;
	}
	public boolean isRepeatS() {
		return repeatS;
	}
	public void setRepeatS(boolean repeatS) {
		this.repeatS = repeatS;
	}
	public boolean isRepeatT() {
		return repeatT;
	}
	public void setRepeatT(boolean repeatT) {
		this.repeatT = repeatT;
	}
}
