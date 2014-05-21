package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Node;

public class NavigationInfo implements Node {

	private double 		avatarSize[];			//avater ���൱�����������ֵָ���������������ʱ��һЩ�ƶ�����
	
	private boolean 	   headlight;			//ȷ��������Ƿ�Ҫ��ͷ��(headlight)��
	
	private double 			   speed;			//ͨ���趨������ƶ��ٶ�ȷ���˹۲����ڳ������ƶ����ٶȣ���λ�� m/s
	
	private String			    type;			//ָ���۲���ʹ�õĵ�������,�����ǡ�WALK������ EXAMINE������FLY���͡�NONE��
	
	private double	 visibilityLimit;			//�趨�������û��ܹ��ڳ����п�������Զ����
	
	
	public NavigationInfo() {
		this(new double[]{0.25,1.6,0.75},true,1.0,"FLY",0.0);
	}

	public NavigationInfo(double[] avatarSize, boolean headlight, double speed,
			String type, double visibilityLimit) {
		this.avatarSize = avatarSize;
		this.headlight = headlight;
		this.speed = speed;
		this.type = type;
		this.visibilityLimit = visibilityLimit;
	}
	
	public double[] getAvatarSize() {
		return avatarSize;
	}
	public void setAvatarSize(double[] avatarSize) {
		this.avatarSize = avatarSize;
	}
	public boolean isHeadlight() {
		return headlight;
	}
	public void setHeadlight(boolean headlight) {
		this.headlight = headlight;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getVisibilityLimit() {
		return visibilityLimit;
	}
	public void setVisibilityLimit(double visibilityLimit) {
		this.visibilityLimit = visibilityLimit;
	}
	
}
