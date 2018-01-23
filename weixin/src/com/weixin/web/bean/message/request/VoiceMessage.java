package com.weixin.web.bean.message.request;

/**
 * 语音消息
 * 
 * @author 黄中正
 *
 */
public class VoiceMessage {

	private String MediaId; // 语音消息媒体id，可以调用多媒体文件下载接口拉取该媒体

	private String Format; // 语音格式：amr

	private String Recognition;// 语音识别结果，UTF8编码

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

}
