package com.bxh.easyvrml.node.extend;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.dom4j.Element;

import com.bxh.easyvrml.impl.Geometry;
import com.bxh.easyvrml.impl.Light;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.basic.TimeSensor;

public class Define {
	
	private static Map<Integer,Map<String,Node>> define ;			//��ΪNode�ڵ��HashCode���룬ֵΪ�ö����Ԥ�������͸ö����ֵ
	
	private static Map<Integer,Boolean> states;						//��λNode�ڵ��HashCode���룬ֵΪ�ö����Ƿ񱻷��ʹ�
	
	static{define = new HashMap<>();
		   states = new HashMap<>();}
	
	/**
	 * Ԥ����һ��������
	 * @param geometry
	 * @param value
	 * @return
	 */
	public static Geometry addGeometryDefine(Geometry geometry,String value){
		return (Geometry)(addDefine(geometry,value));
	}
	
	/**
	 * Ԥ����һ��ʱ��
	 * @param time ��Ҫ�����ʱ��
	 * @param value ʱ�ӵ�����
	 * @return
	 */
	public static TimeSensor addTimerDefine(TimeSensor time,String value){
		return (TimeSensor)(addDefine(time,value));
	}
	
	/**
	 * Ԥ����һ���ƹ�
	 * @param light ��Ҫ����ĵƹ�
	 * @param value �ƹ������
	 * @return
	 */
	public static Light addLightDefine(Light light,String value){
		return (Light)(addDefine(light,value));
	}
	
	/**
	 * ���Ԥ����ڵ���
	 * @param node
	 * @param value
	 * @return
	 */
	public static Node addDefine(Node node,String value){
		Map<String,Node> dv = new HashMap<>();
		dv.put(value, node);
		define.put(node.hashCode(), dv);
		states.put(node.hashCode(), false);
		return node;
	}
	
	/**
	 * ɾ��Ԥ����
	 * @param node
	 */
	public static void removeDefine(Node node){
		define.remove(node.hashCode());
		states.remove(node.hashCode());
	}
	
	/**
	 * �������Ԥ����ڵ���
	 */
	public static void clearDefine(){
		define.clear();
		states.clear();
	}
	/**
	 * �жϸýڵ��Ƿ���Ԥ������
	 * @param node
	 * @return
	 */
	public static boolean isContainDefine(Node node){
		return define.containsKey(node.hashCode());
	}
	
	/**
	 * ͨ���ڵ��ȡ�ڵ������
	 * @param node
	 * @return
	 */
	public static String selectDefine(Node node){
		if(define.containsKey(node.hashCode())){
			states.put(node.hashCode(), true);
			return (String)(define.get(node.hashCode()).keySet().toArray()[0]);
		}
		return null;
	}
	
	public static Boolean selectStates(Node node){
		return states.get(node.hashCode());
	}
	/**
	 * ͨ��Ԥ��������ȡһ��������
	 * @param name
	 * @return
	 */
	public static Geometry getGeometryByName(String name){
		return (Geometry)(getNodeByName(name));
	}
	
	/**
	 * ͨ��Ԥ��������ȡһ��ʱ��
	 * @param name
	 * @return
	 */
	public static TimeSensor getTimerByName(String name){
		return (TimeSensor)(getNodeByName(name));
	}

	/**
	 * ͨ��Ԥ��������ȡһ���ƹ�
	 * @param name
	 * @return
	 */
	public static Light getLightByName(String name){
		return (Light)(getNodeByName(name));
	}

	/**
	 * ͨ��Ԥ��������ȡһ���ڵ�
	 * @param name
	 * @return
	 */
	public static Node getNodeByName(String name){
		Set<Integer> keys = define.keySet();
		for(Iterator<Integer> iterator = keys.iterator();iterator.hasNext();){
			Integer i = iterator.next();
			if(((String)(define.get(i).keySet().toArray()[0])).equals(name)){
				return define.get(i).get(name);
			}
		}
		return null;
	}
	
	public static Map<Integer, Map<String, Node>> getDefine() {
		return define;
	}
}
