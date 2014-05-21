package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Switch implements Node {

	private int		whichChoice;		//�����ı�ţ�������һ���������� choice ������һЩ��Ϊ���ͻ򳡾����ӽڵ���Ϊ��
										//ѡ��������һ������ı���� 0������Ļ����ı�Ŵ����˼�������һ�����Ҳ��
										//��ѡ������һ�������� whichChoice ��ֵС�� 0 ���ߴ��� choice ���е���Ŀ������ô��ѡ
										//���κ����
	
	private Node[]		 choice;		//����һЩ���ͻ򳡾����ӽڵ���Ϊ��ѡ��ĸ������ÿ��������һ����������Ż���
										//������ whichChoice ���еĻ������ȷ��ѡ���ĸ������һ��������������Ϊ 0��
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	
	public Switch(Node[] choice) {
		this(0,choice);
	}
	
	public Switch(int whichChoice, Node[] choice) {
		this.whichChoice = whichChoice;
		this.choice = choice;
		required = new HashMap<>();
		required.put("choice", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("choice", 0);
		exsisted.put("whichChoice", 1);
	}
	
	public int getWhichChoice() {
		return whichChoice;
	}
	public void setWhichChoice(int whichChoice) {
		this.whichChoice = whichChoice;
	}
	public Node[] getChoice() {
		return choice;
	}
	public void setChoice(Node[] choice) {
		this.choice = choice;
	}
}
