package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Geometry;

public class IndexedFaceSet implements Geometry {
	private Coordinate 			 coord;				//�������÷�ͬ�߼��Ͻڵ� IndexedLineSet ������ƣ�ֻ������������ṩ�ռ�ƽ����
													//�εĶ���ĵ�����
	
	private int[] 			coordIndex;				//��Ӧ Coordinate �ڵ�� point ��������б��һ�������б�������������˳����������
													//���γɿռ�Ķ����
	
	private TextureCoordinate texCoord;				//��������һ�� TextureCoordinate �ڵ㣬ָ����һ������ͼƬӳ�䵽�漯������
	
	private int[]		 texCoordIndex; 			//��Ӧ TextureCoordinate �ڵ�������б�
	
	private Color				 color;				//��ֵ�� Color �ڵ㣬Color �ڵ����ֵҲ�� color�����г�������Ϊÿ����Ķ���������
													//��ɫ��һ����ɫ�б�
	
	private int[]			colorIndex;				//��Ӧ Color �ڵ�� color ��ֵ�������б�
	
	private boolean 	colorPerVertex;				//����� color ����һ�� Color �ڵ��������ɫ�б� ����������ֵָ���ǰѶ�Ӧ����ɫ��
													//��ÿ�����㣬���Ǹ���ÿ������
	
	private Normal				normal;				//�����һ�� Normal �ڵ㣬�����˸�����ָ������������ֵ
	
	private int[]		   normalIndex;				//��Ӧ�� Normal �ڵ���������б�������������˳������˱��淨�������ķ�������
	
	private boolean	   normalPerVertex;				//ָ���Ƿ���Ϊÿ�����㻹�Ǹ�ÿ������ȷ���˷�����
	
	private boolean 			   ccw;				//����������������ָ��ÿ�������ϵĶ������������
	
	private boolean				 solid;				//ָ���û��Ƿ��ܿ�������ı���
	
	private boolean				convex;				//�趨�������ı�����͹�Ļ��ǰ���
	
	private double		   creaseAngle;				//ȷ��һ��ת�۽ǣ���������������ļн�С������Ƕȵ�ʱ���������������ı߽�ƽ
													//�����ɣ�����ǿ���������ô����

	public IndexedFaceSet(){
		coord = new Coordinate();
		coordIndex = new int[0];
		texCoord = new TextureCoordinate();
		texCoordIndex = new int[0];
		color = new Color();
		colorIndex = new int[0];
		normal = new Normal();
		normalIndex = new int[0];
	}
	
	public IndexedFaceSet(Coordinate coord, int[] coordIndex,TextureCoordinate texCoord, int[] texCoordIndex, Color color,
			int[] colorIndex, boolean colorPerVertex, Normal normal,int[] normalIndex, boolean normalPerVertex, boolean ccw,
			boolean solid, boolean convex, double creaseAngle) {
		super();
		this.coord = coord;
		this.coordIndex = coordIndex;
		this.texCoord = texCoord;
		this.texCoordIndex = texCoordIndex;
		this.color = color;
		this.colorIndex = colorIndex;
		this.colorPerVertex = colorPerVertex;
		this.normal = normal;
		this.normalIndex = normalIndex;
		this.normalPerVertex = normalPerVertex;
		this.ccw = ccw;
		this.solid = solid;
		this.convex = convex;
		this.creaseAngle = creaseAngle;
	}
	
	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public int[] getCoordIndex() {
		return coordIndex;
	}

	public void setCoordIndex(int[] coordIndex) {
		this.coordIndex = coordIndex;
	}

	public TextureCoordinate getTexCoord() {
		return texCoord;
	}

	public void setTexCoord(TextureCoordinate texCoord) {
		this.texCoord = texCoord;
	}

	public int[] getTexCoordIndex() {
		return texCoordIndex;
	}

	public void setTexCoordIndex(int[] texCoordIndex) {
		this.texCoordIndex = texCoordIndex;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int[] getColorIndex() {
		return colorIndex;
	}

	public void setColorIndex(int[] colorIndex) {
		this.colorIndex = colorIndex;
	}

	public boolean isColorPerVertex() {
		return colorPerVertex;
	}

	public void setColorPerVertex(boolean colorPerVertex) {
		this.colorPerVertex = colorPerVertex;
	}

	public Normal getNormal() {
		return normal;
	}

	public void setNormal(Normal normal) {
		this.normal = normal;
	}

	public int[] getNormalIndex() {
		return normalIndex;
	}

	public void setNormalIndex(int[] normalIndex) {
		this.normalIndex = normalIndex;
	}

	public boolean isNormalPerVertex() {
		return normalPerVertex;
	}

	public void setNormalPerVertex(boolean normalPerVertex) {
		this.normalPerVertex = normalPerVertex;
	}

	public boolean isCcw() {
		return ccw;
	}

	public void setCcw(boolean ccw) {
		this.ccw = ccw;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public boolean isConvex() {
		return convex;
	}

	public void setConvex(boolean convex) {
		this.convex = convex;
	}

	public double getCreaseAngle() {
		return creaseAngle;
	}

	public void setCreaseAngle(double creaseAngle) {
		this.creaseAngle = creaseAngle;
	}
	
	
}
