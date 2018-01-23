package com.weixin.web.bean.message.response;

/**
 * ClassName Image
 * 
 * @Description ����ͼƬ��Ϣ��
 * @author ������
 *
 */
public class Image {
	// ͨ���زĹ���ӿ��ϴ���ý���ļ�,��õ�Id
	private String MediaId;

	public Image(String mediaId) {
		this.MediaId = mediaId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
