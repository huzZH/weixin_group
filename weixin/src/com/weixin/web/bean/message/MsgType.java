package com.weixin.web.bean.message;

/**
 * 请求和响应消息类型
 * 
 * @author 黄中正
 *
 */
public class MsgType {

	// 响应文本消息
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	// 响应图片消息
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	// 响应语音消息
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	// 响应视频消息
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	// 响应小视频消息
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	// 响应链接消息
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/***************************** 响应消息END *************************************/

	// 接收文本消息
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	// 接收图片
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	// 接收语音消息
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	// 接收视频消息
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	// 接收小视频消息
	public static final String REQ_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";
	// 接收上报位置消息
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	// 接收链接消息
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/***************************** 请求消息END *************************************/

	// 接收事件消息
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

}
