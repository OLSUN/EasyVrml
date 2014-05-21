package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;
import com.bxh.easyvrml.tools.VrmlUtils;

/**
 * ViewPoint ���ڱ�ʾһ���ռ��ӵ�
 * 
 * @author BXH
 */
public class Viewpoint implements Node {

	private double position[];				//�ӵ�Ŀռ�����
	
	private double orientation[];			//�ӵ�Ŀռ䳯��
	
	private double fieldOfView;				//�趨�۲��߹۲쳡�����ŵ��ӽǵĴ�С(�ӽ������ 0��С�� pi,ȱʡֵ�൱�� 45��)
	
	private String description;				//�ӵ�����
	
	private boolean jump;					//��������ӵ�֮���л�ʱ���ӵ�λ�ñ仯�ķ�ʽ.��Ϊ TRUE �Ļ���������������λ�ã�������ǰ������λ��֮�����
											//�οռ䣬����Ϊһ����Ծ�ķ�ʽ���������Ϊ FALSE ������������ӵ�仯�����л��ȡ��
											//���ɵķ�ʽ��������ʹ���ӵ���л�������ʹ�ù۲쵽���ӵ��л�ƽ������Ϊ����Ծ�ӵ�仯
											//�ķ�ʽ��
	
	protected Map<String,Integer> required;		//��������

	protected Map<String,Integer> exsisted;		//�Ѵ�������
	
	public final EventIn	set_bind;					//������һ��ֵΪ TRUE ���¼��� Viewpoint �ڵ㼤�ʹ֮��Ϊ��
												//����ǰ�� Viewpoint �ڵ�
	
	public final EventOut	bindTime;					//�ӵ㱻�����ʱ�䡣������¼�������һ�������ӵ㱻����ʱ��ʼ
												//����һ��������ű�
	
	public Viewpoint(){
		this(new double[]{0.0,2.0,20.0},new double[]{1.0,0.0,0.0,VrmlUtils.getDegree(10)},VrmlUtils.getDegree(45),"default",false);
	}
	
	public Viewpoint(double position[],double orientation[],double fieldOfView,String description,boolean jump){
		this.position = position;
		this.orientation = orientation;
		this.fieldOfView = fieldOfView;
		this.description = description;
		this.jump = jump;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("position", 1);
		exsisted.put("orientation", 1);
		exsisted.put("fieldOfView", 1);
		exsisted.put("description", 1);
		exsisted.put("jump", 1);
		
		set_bind = new EventIn("set_bind","SFBool");
		bindTime = new EventOut("bindTime","SFTime");
	}
	

	public double[] getPosition() {
		return position;
	}

	public void setPosition(double[] position) {
		this.position = position;
	}

	public double[] getOrientation() {
		return orientation;
	}

	public void setOrientation(double[] orientation) {
		this.orientation = orientation;
	}

	public double getFieldOfView() {
		return fieldOfView;
	}

	public void setFieldOfView(double fieldOfView) {
		this.fieldOfView = fieldOfView;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isJump() {
		return jump;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
	}

	public EventIn getSet_bind() {
		return set_bind;
	}

	public EventOut getBindTime() {
		return bindTime;
	}
}
