package com.bxh.easyvrml.impl;

import org.dom4j.Document;

import com.bxh.easyvrml.document.VDocument;

/**
 * Compiler �ӿ�������VRML�������ĸ��ֹ��ܺ���ز�����ʵ�ָýӿڲ��Ҹ�д
 * ��Ӧ�ķ���������ɽ�Java�������VRML�Ĺ���
 */

public interface Compiler {

	//���ô���ת���㷨�����м�����ļ���XML��
	public Document compileDocument(VDocument doc);
	
}
