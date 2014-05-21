package com.bxh.mydemo;

import java.io.IOException;

import org.jaxen.function.TranslateFunction;
import org.junit.Test;

import com.bxh.easyvrml.document.DocumentManager;
import com.bxh.easyvrml.document.VDocument;
import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.generator.ExtrusionGenerator;
import com.bxh.easyvrml.generator.IndexedLineGenerator;
import com.bxh.easyvrml.generator.TransformGenerator;
import com.bxh.easyvrml.node.basic.Appearance;
import com.bxh.easyvrml.node.basic.Box;
import com.bxh.easyvrml.node.basic.Cone;
import com.bxh.easyvrml.node.basic.Extrusion;
import com.bxh.easyvrml.node.basic.ImageTexture;
import com.bxh.easyvrml.node.basic.Material;
import com.bxh.easyvrml.node.basic.Shape;
import com.bxh.easyvrml.node.basic.Sphere;
import com.bxh.easyvrml.node.basic.Transform;
import com.bxh.easyvrml.node.extend.Define;
import com.bxh.easyvrml.node.extend.Edge;
import com.bxh.easyvrml.node.extend.Label;
import com.bxh.easyvrml.node.extend.Rotation;
import com.bxh.easyvrml.tools.ColorConfig;
import com.bxh.easyvrml.tools.ViewpointConfig;
import com.bxh.easyvrml.tools.VrmlUtils;

public class Earth {

	private DocumentManager manager;

	@Test
	public void test(){
		manager = new DocumentManager();
		VDocument doc = new VDocument();
		
		doc.addAllViewpoint();

		//̫��
		Define.addDefine(doc.addShape(new Sphere(1.5),ColorConfig.NEON_COLOR_YELLOW), "sun");//����̫��
		doc.addLabelForNode(doc.moveNodeTo(Define.getNodeByName("sun"), new Point3D()), "̫��");						//Ϊ̫����ӱ�ǩ
		
		//ˮ��
		Shape shuix = new Shape(new Sphere(0.1),ColorConfig.SOFT_COLOR_RED);							//����ˮ������
		doc.addLabelForNode(doc.moveNodeTo(shuix,new Point3D(1.8,0,0)), "ˮ��");							//Ϊˮ����ӱ�ǩ
		Shape shuig = new Shape(IndexedLineGenerator.getLineEllipse(new Point3D(0.5,0,0), 1.8, 12));	//����ˮ�ǹ��
		doc.rotationNode(shuig,new Rotation(1,0,0,88));													//��תˮ�ǹ��
				
		//����
		Shape jinx = new Shape(new Sphere(0.2),ColorConfig.SOFT_COLOR_GREEN);							//������������
		doc.addLabelForNode(doc.moveNodeTo(jinx,new Point3D(3,0,0)), "����");							//Ϊ������ӱ�ǩ
		Shape jinxg = new Shape(IndexedLineGenerator.getLineEllipse(new Point3D(0.5,0,0), 3, 12));		//�������ǹ��
		doc.rotationNode(jinxg,new Rotation(1,0,0,93));													//��ת���ǹ��
		
		//����
		Shape diqiu = new Shape(new Sphere(0.2),"earth.jpg");											//������������
		doc.moveNodeTo(diqiu,new Point3D(4,0,0));														//�ƶ���������
		Shape diqiug = new Shape(IndexedLineGenerator.getLineEllipse(4, 12));							//����������
		doc.rotationNode(diqiug,new Rotation(1,0,0,90));												//��ת������
		
		//����
		Shape moon = new Shape(new Sphere(0.05));
		doc.addLabelForNode(doc.moveNodeTo(moon, new Point3D(4.5,0,0)),"����");
		Shape moong = new Shape(IndexedLineGenerator.getLineEllipse(new Point3D(0.0,0,0), 0.5, 12));
		doc.moveAndRotateNodeTo(moong,new Point3D(4.0,0,0),new Rotation(1,0,0,85));
		
		//����
		Shape huox = new Shape(new Sphere(0.19),ColorConfig.SOFT_COLOR_PINK);
		doc.addLabelForNode(doc.moveNodeTo(huox,new Point3D(6,0,0)),"����");
		doc.rotationNode(new Shape(IndexedLineGenerator.getLineEllipse(6, 12)),new Rotation(1,0,0,90));
		
		//ľ��
		Shape mux = new Shape(new Sphere(0.7),"mux.jpg");
		doc.addLabelForNode(doc.moveNodeTo(mux,new Point3D(9,0,0)),"ľ��");
		doc.rotationNode(new Shape(IndexedLineGenerator.getLineEllipse(9, 12)),new Rotation(1,0,0,90));
		
		//����
		Shape tux = new Shape(new Sphere(1.0),"tux.jpg");
		doc.addLabelForNode(doc.moveNodeTo(tux,new Point3D(13,0,0)),"����");
		Shape shape = new Shape(new Extrusion(ExtrusionGenerator.getSpineByIndexedLineSet(IndexedLineGenerator.getLineCircle(1.1)),
											  new double[][]{{0.2,0},{0.5,0},{0.5,0.05},{0.2,0.05},{0.2,0}}),
								"tux.jpg");
		doc.moveAndRotateNodeTo(shape, new Point3D(13,0,0), new Rotation(1,0.2,0,80));
		doc.rotationNode(new Shape(IndexedLineGenerator.getLineEllipse(13, 12)),new Rotation(1,0,0,90));
		
		//������
		Shape twx = new Shape(new Sphere(0.25),ColorConfig.SOFT_COLOR_PINK); 
		doc.addLabelForNode(doc.moveNodeTo(twx,new Point3D(15,0,0)),"������");
		doc.rotationNode(new Shape(IndexedLineGenerator.getLineEllipse(15, 12)),new Rotation(1,0,0,90));
				
		//������
		Shape hwx = new Shape(new Sphere(0.13),ColorConfig.SOFT_COLOR_PINK);
		doc.addLabelForNode(doc.moveNodeTo(hwx,new Point3D(19,0,0)),"������");
		doc.rotationNode(new Shape(IndexedLineGenerator.getLineEllipse(19, 12)),new Rotation(1,0,0,90));
				
		//����
		doc.moveNodeTo(new Shape(new Sphere(0.1)),new Point3D(-5.5,0,0));
		doc.moveAndRotateNodeTo(new Shape(IndexedLineGenerator.getLineEllipse(new Point3D(18,0,0), 18.5, 2)), 
								new Point3D(13,0,0), 
								new Rotation(1,0,0,80));
		
		manager.write(doc,"Earth.wrl");
	}
}
