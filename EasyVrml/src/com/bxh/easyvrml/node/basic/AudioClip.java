package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Node;

public class AudioClip implements Node {
	private String 		description;		//�������ļ�����������
	
	private boolean			   loop;		//�����Ƿ��ظ���������
	
	private double			  pitch;		//���ٻ����ٲ�������������
	
	private Long		  startTime;		//��ʼ����������ʱ��
	
	private Long		   stopTime;		//��������������ʱ��
	
	private String[]		    url;		//ָ����װ��������ļ���·��

	
	public AudioClip(String[] url) {
		this("This is a music",true,1.0,null,null,url);
	}

	public AudioClip(String description, boolean loop, double pitch,Long startTime, Long stopTime, String[] url) {
		this.description = description;
		this.loop = loop;
		this.pitch = pitch;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public double getPitch() {
		return pitch;
	}

	public void setPitch(double pitch) {
		this.pitch = pitch;
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

	public String[] getUrl() {
		return url;
	}

	public void setUrl(String[] url) {
		this.url = url;
	}
}
