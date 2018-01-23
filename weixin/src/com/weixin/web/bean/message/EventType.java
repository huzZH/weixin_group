package com.weixin.web.bean.message;

/**
 * 事件类型
 * 
 * @author 黄中正
 *
 */
public class EventType {
	
	// 接收订阅事件
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	// 接收取消订阅事件
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	// 接收扫描二维码事件
	public static final String EVENT_TYPE_SCAN = "SCAN";
	// 接收上报地理位置事件
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
	// 接收点击菜单拉取消息时的事件
	public static final String EVENT_TYPE_CLICK = "CLICK";
	// 接收点击菜单跳转链接时的事件
	public static final String EVENT_TYPE_VIEW = "VIEW";

}
