package com.bxh.easyvrml.node.basic;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;
import com.bxh.easyvrml.node.extend.Field;

public class Script implements Node {
	private  String         url;				//�ű���·�����߻�ű�������롣����ǽű��ļ������г������ļ�·���������ж��·
												//���������ִ�е�һ�����ܹ����ִ�еĽű�������ǽű��ļ����룬���һ���г��ľ�����
												//ʹ�ó������ƣ�ͨ���� Java��JavaScript ���� VRMLScript 
	
	private  boolean mustEvaluate;				//ÿ���µ�ֵ�� Script �ڵ�����¼� eventIn ����ʱ������ֵ������δ���ű�����
	
	private  boolean directOutput;				//�����ֵ�����Ƿ����� Script �ڵ�Ľű�ֱ�Ӹı䳡���ڵ�Ͷ�̬�ؽ�����ɾ��·��ͨ
												//·
	
	private  String 	eventIn;   			//�������� Script �ڵ��е� eventIn �¼���ָ�����¼����¼����ͺ��¼�����
	
	private  String 	  field;    			//�������� Script �ڵ��е� eventOut �¼���ָ�����¼����¼����ͺ��¼�����
	
	private  String    eventOut;         		//�������� Script �ڵ��е���ָ���������ֵ���ͺ������Ʋ�������Ĭ�ϵ���ֵ
	
	protected Map<String,Integer> required;		//��������

	protected Map<String,Integer> exsisted;		//�Ѵ�������
	
	public Script(String url,EventIn in,EventOut out){
		this("VRMLScript",url,false,false,in.getType() + " " + in.getEventIn(),"",out.getEventOut() + " " +out.getEventOut());
	}
	
	public Script(String url,EventIn in,EventOut out,Field field){
		this("VRMLScript",url,false,false,in.getType() + " " + in.getEventIn(),field.getFieldInfo(),out.getType() + " " +out.getEventOut());
	}
	
	public Script(String script,String url, boolean mustEvaluate, boolean directOutput,
			String eventIn, String field, String eventOut) {
		try {
			this.url = script +":\n\t"+ FileUtils.readFileToString(new File(url));
			this.mustEvaluate = mustEvaluate;
			this.directOutput = directOutput;
			this.eventIn = eventIn;
			this.field = field;
			this.eventOut = eventOut;
			
			required = new HashMap<>();
			required.put("url", 0);
			required.put("eventIn", 0);
			required.put("eventOut", 0);
			
			exsisted = new HashMap<>();
			exsisted.put("url", 1);
			exsisted.put("eventIn", 0);
			exsisted.put("eventOut", 0);
			exsisted.put("mustEvaluate", 1);
			exsisted.put("directOutput", 1);
			exsisted.put("field", 1);
		} catch (IOException e) {
			System.out.println(url+"---");
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isMustEvaluate() {
		return mustEvaluate;
	}

	public void setMustEvaluate(boolean mustEvaluate) {
		this.mustEvaluate = mustEvaluate;
	}

	public boolean isDirectOutput() {
		return directOutput;
	}

	public void setDirectOutput(boolean directOutput) {
		this.directOutput = directOutput;
	}

	public String getEventIn() {
		return eventIn;
	}

	public void setEventIn(String eventIn) {
		this.eventIn = eventIn;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getEventOut() {
		return eventOut;
	}

	public void setEventOut(String eventOut) {
		this.eventOut = eventOut;
	}
	
	
}
