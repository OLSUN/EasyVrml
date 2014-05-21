package com.bxh.easyvrml.impl;

import java.io.File;

import com.bxh.easyvrml.document.VDocument;

public interface Manager {

	public VDocument getDocument();
	
	public void write(VDocument doc);		//����VRML�ĵ�
	
	public void write(VDocument doc,String path);
	
	public void write(VDocument doc,File path);
}
