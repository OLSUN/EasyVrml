package com.bxh.easyvrml.node.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Group implements Node {

	private double[]  bboxCenter;		//�����������ж��������Χ���������
	
	private double[]    bboxSize;		//��Χ�����ӽڵ�İ�Χ������ X��Y��Z ����Ĵ�С
	
	private Node[] 		children;    	//�����ڸ� Group �ڵ�������ӽڵ���б�Ĭ��ֵΪ��ֵ���Ȳ������κ��ӽڵ�

	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public Group(Node[] children) {
		this(new double[]{0.0,0.0,0.0},new double[]{-1,-1,-1},children);
	}

	public Group(double[] bboxCenter, double[] bboxSize, Node[] children) {
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		this.children = children;
		
		required = new HashMap<>();
		required.put("children", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("children", 0);
		exsisted.put("bboxSize", 2);
		exsisted.put("bboxCenter", 2);
	}

	public double[] getBboxCenter() {
		return bboxCenter;
	}

	public void setBboxCenter(double[] bboxCenter) {
		this.bboxCenter = bboxCenter;
	}

	public double[] getBboxSize() {
		return bboxSize;
	}

	public void setBboxSize(double[] bboxSize) {
		this.bboxSize = bboxSize;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	@Override
	public Group clone() {
		ByteArrayOutputStream byteOut = null;   
        ObjectOutputStream objOut = null;   
        ByteArrayInputStream byteIn = null;   
        ObjectInputStream objIn = null;   
           
        try {   
            byteOut = new ByteArrayOutputStream();    
            objOut = new ObjectOutputStream(byteOut);    
            objOut.writeObject(this);   
  
            byteIn = new ByteArrayInputStream(byteOut.toByteArray());   
            objIn = new ObjectInputStream(byteIn);   
               
            return (Group) objIn.readObject();   
        } catch (Exception e) {   
            throw new RuntimeException("Clone Object failed in IO.",e);      
        } finally{   
            try{   
                byteIn = null;   
                byteOut = null;   
                if(objOut != null) objOut.close();      
                if(objIn != null) objIn.close();      
            }catch(IOException e){      
            }      
        } 
	}
	
}
