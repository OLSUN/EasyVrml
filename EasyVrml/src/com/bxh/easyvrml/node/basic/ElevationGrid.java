package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Geometry;

/**
 * ElevationGrid ���ڱ�ʾ����
 * 
 * @author BXH
 */
public class ElevationGrid implements Geometry {

	private int 			xDimension;				//X �����ϵĶ�����������Ϊ��ֵ
	
	private double 			  xSpacing;				//X ����Ķ���֮��ľ��룬����Ϊ��ֵ
	
	private int 			zDimension;				//Z �����ϵĶ�����������Ϊ��ֵ
	
	private double 			  zSpacing;				//Z ����Ķ���֮��ľ��룬����Ϊ��ֵ
	
	private double[] 			height;				//�����Ӧ��ǰ��Ķ���һϵ�еĸ߶�ֵ(�� Y ����ֵ)
	
	private Color 				 color;				//��ֵ��һ�� Color �ڵ㣬�����Ϊÿ���ı��λ�ÿ�����������ɫ������ʹ������ڵ���
													//��һ����ɫ�б�
	
	private boolean 	colorPerVertex;				//ȷ���Ƿ�Ϊÿ�����㻹��Ϊÿ���ı��������ɫ
	
	private Normal				normal;				//���淨������������ȷ������ĳ���ģ����ϣ��Ϊ�����巨�������ɰ���һ��������
													//�� Normal���ýڵ����һ�� vector ��������������ֵ
	
	private boolean    normalPerVertex;				//�����ȷ����Ϊÿ�����㻹��ÿ���ı���Ҳ���������ṩһ��������
	
	private TextureCoordinate texCoord;				//����һ�� TextureCoordinate �ڵ㣬������һ����������������
	
	private boolean 			   ccw;				//�Ǳ�ʾһ�����ֶ���ĺ��壬����˵�����ʱ�뽨���߽磬Ĵָ����Ϊ������Ҳ����
													//ʹ���������泯�ϣ��� Y  ��������һ��
	
	private boolean 			 solid;				//ָ�������Ƿ�ɼ���Ҳ����˵�Ƿ����涼����
	
	private double 		   creaseAngle;				//�趨һ���Ƕȣ�����������ƽ��֮��ļн�С�ڸýǶ�ʱ���� ������ƽ����ƽ���Ĺ��ɽ�

	public ElevationGrid(){
		texCoord = new TextureCoordinate();
		normal = new Normal();
	}
	
	public ElevationGrid(int xDimension, double xSpacing, int zDimension,double zSpacing, double[] height, Color color,
			boolean colorPerVertex, Normal normal, boolean normalPerVertex,TextureCoordinate texCoord, boolean ccw, boolean solid,
			double creaseAngle) {
		super();
		this.xDimension = xDimension;
		this.xSpacing = xSpacing;
		this.zDimension = zDimension;
		this.zSpacing = zSpacing;
		this.height = height;
		this.color = color;
		this.colorPerVertex = colorPerVertex;
		this.normal = normal;
		this.normalPerVertex = normalPerVertex;
		this.texCoord = texCoord;
		this.ccw = ccw;
		this.solid = solid;
		this.creaseAngle = creaseAngle;
	}


	public int getxDimension() {
		return xDimension;
	}

	public void setxDimension(int xDimension) {
		this.xDimension = xDimension;
	}

	public double getxSpacing() {
		return xSpacing;
	}

	public void setxSpacing(double xSpacing) {
		this.xSpacing = xSpacing;
	}

	public int getzDimension() {
		return zDimension;
	}

	public void setzDimension(int zDimension) {
		this.zDimension = zDimension;
	}

	public double getzSpacing() {
		return zSpacing;
	}

	public void setzSpacing(double zSpacing) {
		this.zSpacing = zSpacing;
	}

	public double[] getHeight() {
		return height;
	}

	public void setHeight(double[] height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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

	public boolean isNormalPerVertex() {
		return normalPerVertex;
	}

	public void setNormalPerVertex(boolean normalPerVertex) {
		this.normalPerVertex = normalPerVertex;
	}

	public TextureCoordinate getTexCoord() {
		return texCoord;
	}

	public void setTexCoord(TextureCoordinate texCoord) {
		this.texCoord = texCoord;
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

	public double getCreaseAngle() {
		return creaseAngle;
	}

	public void setCreaseAngle(double creaseAngle) {
		this.creaseAngle = creaseAngle;
	}
	
}
