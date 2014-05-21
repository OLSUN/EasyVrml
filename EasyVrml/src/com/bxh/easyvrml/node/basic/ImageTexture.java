package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Texture;

public class ImageTexture implements Texture {
	private String  	 url;			//ָ����Ϊ�����ļ����ⲿͼ���ļ�·������·���Ǵ����ϵ��ض�λ�ã�Ĭ���ǵ�ǰ�ļ��С�
										//�� url �������ָ�����ͼ���ļ���·����������ᰴ��ָ�����Ⱥ�˳��װ�ظñ��е�һ����
										//���ҵ����ļ������⵱��Щ·��ʧЧ��ʱ�����Ͳ����������
	private boolean  repeatS;			//�����ֵָ������������ S �����ϵ�����ӳ���Ƿ���ظ����������������͵ı���
	
	private boolean  repeatT;			//�����ֵָ������������ T �����ϵ�����ӳ���Ƿ���ظ����������������͵ı���

	protected final Map<String,Integer> required;		//��������

	protected final Map<String,Integer> exsisted;		//�Ѵ�������
	
	
	public ImageTexture(String url) {
		this(url,false,false);
	}

	public ImageTexture(String url, boolean repeatS, boolean repeatT) {
		this.url = url;
		this.repeatS = repeatS;
		this.repeatT = repeatT;
		
		required = new HashMap<>();
		required.put("url", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("url", 0);
		exsisted.put("repeatS", 1);
		exsisted.put("repeatT", 1);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isRepeatS() {
		return repeatS;
	}

	public void setRepeatS(boolean repeatS) {
		this.repeatS = repeatS;
	}

	public boolean isRepeatT() {
		return repeatT;
	}

	public void setRepeatT(boolean repeatT) {
		this.repeatT = repeatT;
	}
}
