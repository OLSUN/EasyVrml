package com.bxh.easyvrml.node.extend;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

/**
 * Route �ڵ���Ҫ������һ��·���¼�
 * @author BXH
 *
 */
public class ROUTE implements Node{
	
	private EventIn		 eventIn;		//���¼�
	private EventOut	eventOut;		//���¼�
	
	private Node 		 nodeOut;
	private Node 		  nodeIn;
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public ROUTE(Node nodeOut,EventOut eventOut,Node nodeIn,EventIn eventIn) {
		this.eventIn = eventIn;
		this.eventOut = eventOut;
		this.nodeOut = nodeOut;
		this.nodeIn = nodeIn;
		
		required = new HashMap<>();
		required.put("eventIn", 0);
		required.put("eventOut", 0);
		required.put("nodeOut", 0);
		required.put("nodeIn", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("eventIn", 0);
		exsisted.put("eventOut", 0);
		exsisted.put("nodeOut", 0);
		exsisted.put("nodeIn", 0);
	}
	
	public EventIn getEventIn() {
		return eventIn;
	}
	
	public void setEventIn(EventIn eventIn) {
		this.eventIn = eventIn;
	}
	
	public EventOut getEventOut() {
		return eventOut;
	}
	
	public void setEventOut(EventOut eventOut) {
		this.eventOut = eventOut;
	}

	public String getRoute(){
		return "ROUTE " + Define.selectDefine(nodeOut) + "." + eventOut.getEventOut() + " TO " + Define.selectDefine(nodeIn) +"." +eventIn.getEventIn();
	}
}
