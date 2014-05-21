package com.bxh.easyvrml.document;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;

import com.bxh.easyvrml.impl.Analyzer;
import com.bxh.easyvrml.impl.Compiler;
import com.bxh.easyvrml.analyzer.StandardAnalyzer;
import com.bxh.easyvrml.compiler.StandardCompiler;
import com.bxh.easyvrml.impl.Manager;
import com.bxh.easyvrml.tools.XMLUtils;

/**
 * DocumentManager�ṩDocument�ĵ������Ĺ���CRUD������
 * @author BXH
 */
public class DocumentManager implements Manager{

	private Compiler compiler;			//������
	private Analyzer analyzer;			//������
	
	public DocumentManager(){
		this(new StandardCompiler(),new StandardAnalyzer());
	}
	
	public DocumentManager(Compiler compiler,Analyzer analyzer){
		this.compiler = compiler;
		this.analyzer = analyzer;
	}

	@Override
	public void write(VDocument doc) {
		write(doc,"test.wrl");
	}

	@Override
	public void write(VDocument doc, String path) {
		write(doc,new File(path));
	}

	@Override
	public void write(VDocument doc, File path) {
		Document xmldoc = compiler.compileDocument(doc);		//���������м����
		VrmlCodeStream code = analyzer.parseDocument(xmldoc);
		try {
			XMLUtils.write(xmldoc);
			FileUtils.writeStringToFile(path,code.getContent().toString(),"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Compiler getCompiler() {
		return compiler;
	}

	public void setCompiler(Compiler compiler) {
		this.compiler = compiler;
	}

	public Analyzer getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}

	@Override
	public VDocument getDocument() {
		return new VDocument();
	}
}
