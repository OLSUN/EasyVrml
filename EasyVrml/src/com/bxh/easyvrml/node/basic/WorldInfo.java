package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Node;

/**
 *    WorldInfo �ڵ����λ�� VRML �ļ��е��κεط������г������й���Ϣ�����Ըó�����
 * �Ӿ�Ч���Ͷ���û���κ�Ӱ�죬������Ϊ�ĵ����֡�ʹ�� WorldInfo �ڵ���ĵ�����˵������
 * �߳���Ŀɶ��ԣ�������������
 *
 * @author BXH
 */
public class WorldInfo implements Node {

	private String title;		//����������ڵı���������ʾ�ĵ�ǰ�����ı���
	private String info[];		//���ڳ�����������Ϣ�������ߡ�����ʱ�䡢��Ȩ��Ϣ��
								//info ["Author:Wubeixin","Date:2003-11-03"]
	
	public WorldInfo(){
		this("",new String[]{""});
	}
	
	public WorldInfo(String title,String info[]){
		this.title = title;
		this.info = info;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getInfo() {
		return info;
	}

	public void setInfo(String[] info) {
		this.info = info;
	}
}
