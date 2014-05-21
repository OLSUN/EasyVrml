package com.bxh.easyvrml.document;

import java.util.LinkedList;
import java.util.List;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.generator.ExtrusionGenerator;
import com.bxh.easyvrml.generator.IndexedLineGenerator;
import com.bxh.easyvrml.generator.TransformGenerator;
import com.bxh.easyvrml.impl.Geometry;
import com.bxh.easyvrml.impl.Interpolator;
import com.bxh.easyvrml.impl.Layout;
import com.bxh.easyvrml.impl.Light;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.basic.Appearance;
import com.bxh.easyvrml.node.basic.Billboard;
import com.bxh.easyvrml.node.basic.Cone;
import com.bxh.easyvrml.node.basic.Cylinder;
import com.bxh.easyvrml.node.basic.Extrusion;
import com.bxh.easyvrml.node.basic.FontStyle;
import com.bxh.easyvrml.node.basic.Material;
import com.bxh.easyvrml.node.basic.PROTO;
import com.bxh.easyvrml.node.basic.Script;
import com.bxh.easyvrml.node.basic.Shape;
import com.bxh.easyvrml.node.basic.Sphere;
import com.bxh.easyvrml.node.basic.Text;
import com.bxh.easyvrml.node.basic.TimeSensor;
import com.bxh.easyvrml.node.basic.Transform;
import com.bxh.easyvrml.node.basic.Version;
import com.bxh.easyvrml.node.basic.Viewpoint;
import com.bxh.easyvrml.node.extend.Define;
import com.bxh.easyvrml.node.extend.Edge;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.Label;
import com.bxh.easyvrml.node.extend.ROUTE;
import com.bxh.easyvrml.node.extend.Rotation;
import com.bxh.easyvrml.tools.ColorConfig;
import com.bxh.easyvrml.tools.ViewpointConfig;
import com.bxh.easyvrml.tools.VrmlUtils;

/**
 * Document ��ʾ������VRML�ĵ����ڲ�ӵ��һ��Ԫ��
 * 
 * @author BXH
 *
 */
public class VDocument{

	private Version version;						//�ĵ��İ汾��Ϣ
	
	private List<Node> nodes ;						//�ڵ��б��洢�ĵ��е�����Ԫ��
	
	private List<ROUTE> routes;						//·���б�
	
	private List<PROTO> protos;						//ԭ�������б�
	
	public static boolean isPrintCode;				//�Ƿ��ӡ����
	
	public VDocument(){
		this(new Version());
	}
	
	public VDocument(Version version){
		nodes  = new LinkedList<>();				//��ʼ���ڵ��б�
		routes = new LinkedList<>();				//��ʼ��·�ɽڵ��б�
//		protos = new LinkedList<>();				//��ʼ��Ԥ����ڵ��б�
		setVersion(version);						//�����ĵ��汾��Ϣ
	}
	
	public Transform rotationNode(Node node,Rotation rotation){
		return (Transform)addNode(TransformGenerator.rotateNode(node, rotation));
	}
	
	public Node moveAndRotateNodeTo(Node node,Point3D point,Rotation rotation){
		return addNode(TransformGenerator.moveAndRotateNodeTo(node,point,rotation));
	}
	
	public Transform moveNodeTo(Node node,Point3D point){
		Transform tran = TransformGenerator.moveNodeTo(node, point);
		return (Transform)addNode(tran);
	}
	
	public Shape addShape(Geometry geometry,int colorType){
		return (Shape)addNode(new Shape(new Appearance(new Material(colorType)),geometry));
	}
	
	public Shape addShape(Geometry geometry){
		return (Shape)addNode(new Shape(geometry));
	}
	
	public Shape addShape(Appearance appearance,Geometry geometry){
		return (Shape)addNode(new Shape(appearance,geometry));
	}
	public void addAllViewpoint(){
		addViewpoint(ViewpointConfig.V_FRONT);
		addViewpoint(ViewpointConfig.V_BACK);
		addViewpoint(ViewpointConfig.V_LEFT);
		addViewpoint(ViewpointConfig.V_RIGHT);
		addViewpoint(ViewpointConfig.V_DOWN);
		addViewpoint(ViewpointConfig.V_UP);
		addViewpoint(ViewpointConfig.V_FRONT_LEFT_UP);
		addViewpoint(ViewpointConfig.V_FRONT_RIGHT_UP);
	}
	/**
	 * ���һ���ӵ�ڵ�
	 * @param type	�ӵ�ķ���
	 * @return	�ӵ�
	 */
	public Viewpoint addViewpoint(int type){
		return (Viewpoint)addNode(ViewpointConfig.getViewpoint(type));
	}
	/**
	 * �콣һ���ӵ�ڵ�
	 * @param view	�Զ�����ӵ�
	 * @return
	 */
	public Viewpoint addViewpoint(Viewpoint view){
		return (Viewpoint)addNode(view);
	}
	/**
	 * 
	 * @param tran
	 * @param label
	 * @return
	 */
	public Label addLabelForNode(Transform tran,String label){
		Billboard b = new Billboard(new Node[]{new Shape(new Text(new String[]{label},
														 		  new double[]{0}, 
														 		  0,
														 		  new FontStyle(0.5)))});
		addNode(TransformGenerator.moveNodeTo(b, 
											  VrmlUtils.getLabelLocation(tran)));
		return new Label(label,0.5);
	}
	/**
	 * 
	 * @param tran
	 * @param label
	 * @return
	 */
	public Label addLabelForNode(Transform tran,Label label){
		Billboard b = new Billboard(new Node[]{new Shape(new Text(new String[]{label.getText()},
																  new double[]{0}, 
																  0, 
																  new FontStyle(label.getSize())))});
		addNode(TransformGenerator.moveNodeTo(b, 
											  VrmlUtils.getLabelLocation(tran)));
		return label;
	}
	/**
	 * 
	 * @param edge
	 * @return
	 */
	public Edge addEdgeByPoints(Edge edge){
		Point3D _start = edge.get_start();
		Shape shape = new Shape(new Extrusion(
				ExtrusionGenerator.getSpineByIndexedLineSet(IndexedLineGenerator.getLine(_start, 
																						 edge.get_end())), 
				ExtrusionGenerator.getCrossSectionByIndexedLineSet(IndexedLineGenerator.getLineCircle(0.1))));
		addNode(shape);
		return edge;
	}
	/**
	 * 
	 * @param edge
	 * @return
	 */
	public Edge addEdge(Edge edge){
		Point3D _start = edge.getStartPoint();
		Shape shape = new Shape(new Extrusion(
				ExtrusionGenerator.getSpineByIndexedLineSet(IndexedLineGenerator.getLine(_start, 
																						 edge.getEndPoint())), 
				ExtrusionGenerator.getCrossSectionByIndexedLineSet(IndexedLineGenerator.getLineCircle(0.1))));
		addNode(shape);
		return edge;
	}
	/**
	 * 
	 * @param trans
	 */
	public void addEdges(Transform []trans){
		for(int i = 0;i<trans.length ;i++){
			Edge _e = new Edge(trans[i],trans[(i+1)%trans.length]);
			addEdge(_e);
		}
	}
	
	/**
	 * ���ԭ������
	 * @param proto ԭ��
	 * @return 
	 */
	public PROTO addProto(PROTO proto){
		protos.add(proto);
		return proto;
	}
	
	/**
	 * ���һ���ڵ㵽�ڵ��б���
	 * @param node ��Ҫ��ӵĽڵ�
	 * @return �ո���ӵĽڵ�
	 */
	public Node addNode(Node node){
		nodes.add(node);
		return node;
	}
	/**
	 * ���һ���ڵ����鵽�ڵ��б���
	 * @param node
	 * @return
	 */
	public Node[] addNode(Node[] node){
		for(int i =0;i<node.length;i++){
			nodes.add(node[i]);
		}
		return node;
	}
	
	/**
	 * ɾ��ָ���Ľڵ�
	 * @param node
	 */
	public void deleteNode(Node node){
		if(nodes.contains(node)){
			nodes.remove(node);
		}else{
			System.out.println("δ�ҵ�ɾ������!");
		}
	}
	
	/**
	 * Ϊ�ĵ��������ϵ
	 */
	public void addCoordinate(){
		addNode(new Shape(IndexedLineGenerator.getCoordinate()));
		addNode(TransformGenerator.moveAndRotateNodeTo(Define.addDefine(new Shape(new Cone(0.2, 0.1)), "_c_x_"), 
													   new Point3D(10,0,0), 
													   new Rotation(0, 0, 1, -90)));
		addNode(TransformGenerator.moveNodeTo(Define.getNodeByName("_c_x_"), 
											  new Point3D(0,10,0)));
		addNode(TransformGenerator.moveAndRotateNodeTo(Define.getNodeByName("_c_x_"), 
													   new Point3D(0,0,10), 
													   new Rotation(1, 0, 0, 90)));
	}
	
	//���һ����
	public void addFace(){
		
	}
	
	/**
	 * ��ӹ�Դ
	 * @param light ��Ҫ��ӵĹ�Դ
	 * @return �ո���ӵĹ�Դ
	 */
	public Light addLight(Light light){
		return (Light)(addNode(light));
	}
	
	/**
	 * ��Ӽ�ʱ��
	 * @param time
	 * @return
	 */
	public TimeSensor addTimer(TimeSensor time){
		return (TimeSensor)(addNode(time));
	}
	
	/**
	 * ��ȡ�ڵ��б�
	 * @return �ڵ��б�
	 */
	public List<Node> getNodes() {
		return nodes;
	}

	/**
	 * ��ȡ�ĵ��汾��Ϣ
	 * @return
	 */
	public Version getVersion() {
		return version;
	}

	/**
	 * �����ĵ��İ汾��Ϣ
	 * @param version
	 */
	public void setVersion(Version version) {
		this.version = version;
	}

	/**
	 * ��ȡ�ĵ���·���б�
	 * @return 
	 */
	public List<ROUTE> getRoutes() {
		return routes;
	}

	/**
	 * ��·���б������·��
	 * @param route
	 */
	public void addRoutes(ROUTE route) {
		this.routes.add(route);
	}
	
	/**
	 * ��Ӳ岹����·��
	 * @param time ʱ��
	 * @param interpolator �岹��
	 * @param node ��Ҫ�ı����ԵĽڵ�
	 * @param in ��Ҫ�ı�ڵ���¼�
	 */
	public void addInterpolatorRoutes(TimeSensor time,Interpolator interpolator,Node node,EventIn in) {
		addRoutes(new ROUTE(time,
							time.getFraction_changed(),
							interpolator,
							interpolator.getSet_fraction()));
		addRoutes(new ROUTE(interpolator,
							interpolator.getValue_changed(),
							node,
							in));
	}

	public static boolean isPrintCode() {
		return isPrintCode;
	}

	public static void setPrintCode(boolean isPrintCode) {
		VDocument.isPrintCode = isPrintCode;
	}
}
