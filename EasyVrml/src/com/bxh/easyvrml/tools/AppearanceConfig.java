package com.bxh.easyvrml.tools;

import com.bxh.easyvrml.node.basic.Appearance;
import com.bxh.easyvrml.node.basic.Material;

public class AppearanceConfig {

	//��ȡָ����ɫ�Ĳ���
	public static Appearance getColorAppearance(int type){
		return new Appearance(new Material(type));
	}
		
}
