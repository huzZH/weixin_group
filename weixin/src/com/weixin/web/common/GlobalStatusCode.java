package com.weixin.web.common;

/**
 * 全局返回码说明
 * 
 * @author 黄中正
 *
 */
public enum GlobalStatusCode {

	SYS_BUSY(-1, "系统繁忙"),

	SUCCESS(0, "请求成功"),

	APPSECRET_ERROR(40001, "AppSecret 错误,或者 access_token 无效"),

	ILLEGAL_PROOF_TYPE(40002, "不合法的凭证类型"),

	ILLEGAL_OPENID(40003, "不合法的OpenId"),

	ILLEGAL_MEDIA_FILE_TYPE(40004, "不合法的媒体文件类型"),

	ILLEGAL_FILE_TYPE(40005, "不合法的文件类型"),

	ILLEGAL_FILE_SIZE(40006, "不合法的文件大小"),

	ILLEGAL_MEDIA_FILE_ID(40007, "不合法的媒体文件 id"),

	ILLEGAL_MSG_TYPE(40008, "不合法的消息类型"),

	ILLEGAL_IMAGE_FILE_SIZE(40009, "不合法的图片文件大小"),

	ILLEGAL_VOICE_FILE_SIZE(40010, "不合法的语音文件大小"),

	ILLEGAL_VIDEO_FILE_TYPE(40011, "不合法的视频文件大小"),

	ILLEGAL_THUMBNAIL_FILE_TYPE(40012, "不合法的缩略图文件大小"),

	ILLEGAL_APPID(40013, "不合法的 AppID "),

	ILLEGAL_ACCESS_TOKEN(40014, "不合法的 access_token"),

	ILLEGAL_MENU_TYPE(40015, "不合法的菜单类型"),

	ILLEGAL_BUTTON_NUM_16(40016, "不合法的按钮个数"),

	ILLEGAL_BUTTON_NUM_17(40017, "不合法的按钮个数"),

	ILLEGAL_BUTTON_NAME_LENGTH(40017, "不合法的按钮名字长度"),

	ILLEGAL_BUTTON_KEY_LENGTH(40019, "不合法的按钮 KEY 长度"),

	ILLEGAL_BUTTON_URL_LENGTH(40020, "不合法的按钮 URL 长度");

	private int code;
	
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	GlobalStatusCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
