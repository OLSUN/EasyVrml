package com.bxh.easyvrml.node.extend;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.basic.Transform;
import com.bxh.easyvrml.tools.VrmlUtils;

/**
 * Edge ��ʾ�ڵ�֮��ıߣ�������������_start��_end����_start��ʾ��ʼ�㣬_end��ʾ��ֹ��
 * 
 * @author BXH
 */
public class Edge {

	private Transform start;		//��ʼ��
	private Transform end;			//��ֹ��
	
	private Point3D _start;
	
	private Point3D _end;
	
	/**
	 * Eage �Ĺ��캯��
	 * @param _start	��ʼ��ڵ�
	 * @param _end	��ֹ��ڵ�
	 */
	public Edge(Transform start,Transform end){
		this.start = start;
		this.end   = end;
	}
	
	public Edge(Point3D start,Point3D end){
		this._start = start;
		this._end   = end;
	}
	
	public Point3D getStartPoint(){
		return VrmlUtils.getLocationOfTransform(start);
	}
	
	public Point3D getEndPoint(){
		return VrmlUtils.getLocationOfTransform(end);
	}
	
	public Transform getStart() {
		return start;
	}

	public void setStart(Transform start) {
		this.start = start;
	}

	public Transform getEnd() {
		return end;
	}

	public void setEnd(Transform end) {
		this.end = end;
	}

	public Point3D get_start() {
		return _start;
	}

	public void set_start(Point3D _start) {
		this._start = _start;
	}

	public Point3D get_end() {
		return _end;
	}

	public void set_end(Point3D _end) {
		this._end = _end;
	}
}
