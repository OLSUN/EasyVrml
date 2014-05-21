package com.bxh.easyvrml.tools;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.impl.Geometry;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.basic.Appearance;
import com.bxh.easyvrml.node.basic.Box;
import com.bxh.easyvrml.node.basic.Cone;
import com.bxh.easyvrml.node.basic.Cylinder;
import com.bxh.easyvrml.node.basic.Material;
import com.bxh.easyvrml.node.basic.Shape;
import com.bxh.easyvrml.node.basic.Sphere;
import com.bxh.easyvrml.node.basic.Transform;

/**
 * �ṩһЩ�����Ķ���VRMLԪ�صĲ���
 * 
 * @author BXH
 */
public class VrmlUtils {

	public static double _sin(double degree){
		return Math.sin(VrmlUtils.getDegree(degree));
	}
	
	public static double _cos(double degree){
		return Math.cos(VrmlUtils.getDegree(degree));
	}
	
	/**
	 * �����ȡ�ڵ��VRML����
	 * @param cls �ڵ��Class
	 * @return	�ڵ� ��VRML����
	 */
	public static String getNodeName(Class<?> cls){
		return cls.getSimpleName();
	}		
	
	/**
	 * ���һ���Ƕȶ�Ӧ�Ļ���ֵ
	 * @param d �Ƕ�
	 * @return ����
	 */
	public static double getDegree(double d){
		return Math.PI/180*d;
	}

	/**
	 * �ж�һ�������Ƿ���Ա���ʾ������ȨС�ڵ���1��
	 * @param node
	 * @param field
	 * @return
	 */
	public static boolean isCanShow(Node node,Field field){
		try {
			Field _fe = node.getClass().getDeclaredField("exsisted");
			_fe.setAccessible(true);
			@SuppressWarnings("unchecked")
			Map<String,Integer> e = (Map<String,Integer>)(_fe.get(node));
			Integer _i = e.get(field.getName());
			if(_i!=null && _i<=1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * �ж�һ���ڵ�ı��������Ƿ�ȫ����ֵ
	 * @param node	��Ҫ�����Ľڵ�
	 * @return	�Ƿ����б������Զ�����ֵ
	 */
	public static boolean isFullyFields(Node node){
		try {
			Field _fr = node.getClass().getDeclaredField("required");
			Field _fe = node.getClass().getDeclaredField("exsisted"); 
			_fr.setAccessible(true);
			_fe.setAccessible(true);
			
			@SuppressWarnings("unchecked")
			Map<String,String> r = (Map<String,String>)(_fr.get(node));
			@SuppressWarnings("unchecked")
			Map<String,String> e = (Map<String,String>)(_fe.get(node));
			Set<String> keys = r.keySet();
			for(Iterator<String> i = keys.iterator();i.hasNext();){
				String _v = i.next();
				if(e.get(_v)==null){
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return true;
	}
	/**
	 * ����һ��������Transform�ڵ㣬�����������ļ��νڵ�����Ͻ�����
	 * @param tran ��Ҫ�����Transform�ڵ�
	 * @return 
	 */
	public static Point3D getLabelLocation(Transform tran){
		Point3D _p = getLocationOfTransform(tran);
		try {
			Field _translation = tran.getClass().getDeclaredField("children");
			_translation.setAccessible(true);
			Node []child = (Node[])_translation.get(tran);
			if(child!=null&&child.length==1&&VrmlUtils.getNodeName(child[0].getClass()).equals("Shape")){
				Shape _shape = (Shape)child[0];
				Geometry _ge = _shape.getGeometry();
				String type = VrmlUtils.getNodeName(_ge.getClass());
				if(type.equals("Box")){
					Box box = (Box)_ge;
					return new Point3D(_p.getX() + box.getX()/2,
									   _p.getY() + box.getY()/2,
									   _p.getZ() );
				}else if(type.equals("Sphere")){
					Sphere box = (Sphere)_ge;
					return new Point3D(_p.getX() + box.getRadius() - 0.1,
									   _p.getY() + box.getRadius() - 0.1,
									   _p.getZ());
				}else if(type.equals("Cone")){
					Cone box = (Cone)_ge;
					return new Point3D(_p.getX() + box.getBottomRadius(),
									   _p.getY() + box.getHeight()/2,
									   _p.getZ());
				}else if(type.equals("Cylinder")){
					Cylinder box = (Cylinder)_ge;
					return new Point3D(_p.getX() + box.getRadius(),
									   _p.getY() + box.getHeight()/2,
									   _p.getZ() );
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return _p;
	}
	
	/**
	 * ��ȡһ���ڵ��λ��
	 * @param tran λ�ýڵ�
	 * @return
	 */
	public static Point3D getLocationOfTransform(Transform tran){
		try {
			Field _translation = tran.getClass().getDeclaredField("translation");
			_translation.setAccessible(true);
			double []center = (double[])_translation.get(tran);
			if(center!=null){
				return new Point3D(center[0],center[1],center[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
