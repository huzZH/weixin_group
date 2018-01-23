package com.weixin.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weixin.web.bean.message.MsgType;
import com.weixin.web.handle.EventHandler;
import com.weixin.web.handle.MsgHandler;
import com.weixin.web.handle.XmlResolveHandler;

@Component
public class WeChatDispatcher {


	private Logger logger = Logger.getLogger(WeChatDispatcher.class);

	private static final String MSG_TYPE = "MsgType";


	@Autowired
	private XmlResolveHandler XmlResolveHandler;
	
	@Resource(name="defaultMsgHandler")
	private  MsgHandler msgHandler;
	
	@Resource(name="defaultEventHandler")
	private  EventHandler eventHandler;


	public String handleRequestFromWeChat(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, String> xmlMap = XmlResolveHandler.parseXmlToMap(request);

			String msgType = xmlMap.get(MSG_TYPE);
			// 事件类型
			if (msgType.equals(MsgType.REQ_MESSAGE_TYPE_EVENT)) {

			} else { // 消息类型
				msgHandler.processMessage(msgType, xmlMap, response);
			}

		} catch (Exception e) {
			logger.error("解析请求失败", e);
		}
		return null;
	}
}
