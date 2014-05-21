package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.impl.Texture;

public class Appearance implements Node {

	private Material 				material;	//����ֵͨ��ʹ�� Material �ڵ����������͵Ļ���������ֵ�������
	
	private Texture 				texture;	//�������������þ�̬���߶�̬�����Ӷ�ʹ���͸�������������
	
	private TextureTransform textureTransform;	// ������������ı任�� �������ƽ�ơ���ת�����ŵȵȣ�ʹ�������׼ȷ
	
	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	public Appearance(){
		this(new Material());
	}
	
	public Appearance(Material material){
		this.material = material;
		required = new HashMap<>();
		required.put("material", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("material", 0);
	}
	
	public Appearance(Texture texture){
		this(texture,new TextureTransform());
	}
	
	public Appearance(Texture texture,TextureTransform textureTransform){
		this.texture = texture;
		this.textureTransform = textureTransform;
		
		required = new HashMap<>();
		required.put("texture", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("texture", 0);
		exsisted.put("textureTransform", 1);
	}
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public TextureTransform getTextureTransform() {
		return textureTransform;
	}

	public void setTextureTransform(TextureTransform textureTransform) {
		this.textureTransform = textureTransform;
	}
}
