package com.weixin.web.bean.message.response;
/**
 * ClassName MusicMessage
 * @Description ����������Ϣ��
 * @author ������
 *
 */
public class Music {
	//���ֱ���
	private String Title;
	//��������
	private String Description;
	//��������
	private String MusicURL;
	//�������������ӣ�WIFI��������ʹ�ø����Ӳ�������
	private String HQMusicUrl;
	//����ͼ��ý��id,ͨ���زĹ���ӿ��ϴ���ý���ļ�,�õ���id
	private String ThumbMediaId;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMusicURL() {
		return MusicURL;
	}
	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
	
}
