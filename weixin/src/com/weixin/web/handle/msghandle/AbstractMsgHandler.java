package com.weixin.web.handle.msghandle;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.weixin.web.bean.message.MsgType;
import com.weixin.web.handle.MsgHandler;

public abstract class AbstractMsgHandler implements MsgHandler {

	@Autowired
	private ReqTextMsgHandler reqTextMsgHandler;
	@Autowired
	private ReqImageMsgHandler reqImageMsgHandler;
	@Autowired
	private ReqVideoMsgHandler reqVideoMsgHandler;
	@Autowired
	private ReqShortVideoMsgHandler reqShortVideoMsgHandler;
	@Autowired
	private ReqVoiceMsgHandler reqVoiceMsgHandler;
	@Autowired
	private ReqLocationMsgHandler reqLocationMsgHandler;
	@Autowired
	private ReqLinkMsgHandler reqLinkMsgHandler;

	/**
	 * 处理消息
	 * 
	 * @param msgType
	 *            消息类型
	 * @param xmlMap
	 *            消息数据集
	 */
	@Override
	public void processMessage(String msgType, Map<String, String> xmlMap, HttpServletResponse response) {

		switch (msgType) {

		case MsgType.REQ_MESSAGE_TYPE_TEXT:
			reqTextMsgHandler.handleMsg(xmlMap, response);
			break;
		case MsgType.REQ_MESSAGE_TYPE_IMAGE:
			reqImageMsgHandler.handleMsg(xmlMap, response);
			break;
		case MsgType.REQ_MESSAGE_TYPE_VIDEO:
			reqVideoMsgHandler.handleMsg(xmlMap, response);
			break;
		case MsgType.REQ_MESSAGE_TYPE_VOICE:
			reqVoiceMsgHandler.handleMsg(xmlMap, response);
			break;
		case MsgType.REQ_MESSAGE_TYPE_SHORTVIDEO:
			reqShortVideoMsgHandler.handleMsg(xmlMap, response);
			break;
		case MsgType.REQ_MESSAGE_TYPE_LOCATION:
			reqLocationMsgHandler.handleMsg(xmlMap, response);
			break;
		case MsgType.REQ_MESSAGE_TYPE_LINK:
			reqLinkMsgHandler.handleMsg(xmlMap, response);
			break;

		}

	}

	@Override
	public void handleMsg(Map<String, String> xmlMap, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
}
