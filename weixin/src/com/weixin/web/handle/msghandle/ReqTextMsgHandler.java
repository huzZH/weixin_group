package com.weixin.web.handle.msghandle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;
import com.weixin.web.bean.message.request.TextMessage;
import com.weixin.web.bean.message.response.RespTextMessage;

/**
 * 回复文本消息
 * 
 * @author 黄中正
 *
 */
@Component
public class ReqTextMsgHandler extends AbstractMsgHandler {

	private static Logger logger = Logger.getLogger(ReqTextMsgHandler.class);

	@Override
	public void handleMsg(Map<String, String> xmlMap, HttpServletResponse response) {

		String toUserName = xmlMap.get("ToUserName");
		String fromUserName = xmlMap.get("FromUserName");
		String content = xmlMap.get("Content");
		Long createTime = Long.valueOf(xmlMap.get("CreateTime"));
		Long msgId = Long.valueOf(xmlMap.get("MsgId"));
		String msgType = xmlMap.get("MsgType");

		TextMessage textMessage = new TextMessage();
		textMessage.setFromUserName(fromUserName);
		textMessage.setToUserName(toUserName);
		textMessage.setContent(content);
		textMessage.setCreateTime(createTime);
		textMessage.setMsgType(msgType);
		textMessage.setMsgId(msgId);
		logger.info("接收到的消息 " + textMessage.toString());
		sendMsg(response, textMessage);
	}

	/**
	 * 发送消息
	 * 
	 * @param response
	 * @param textMessage
	 */
	private void sendMsg(HttpServletResponse response, TextMessage textMessage) {

		RespTextMessage respMsg = new RespTextMessage();
		respMsg.setToUserName(textMessage.getFromUserName());
		respMsg.setFromUserName(textMessage.getToUserName());
		respMsg.setCreateTime(textMessage.getCreateTime());
		respMsg.setMsgType(textMessage.getMsgType());
		respMsg.setContent("收到文本消息了");

		String textMessageToXml = textMessageToXml(respMsg);
		logger.info("发送的消息体: " + textMessageToXml);
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(textMessageToXml);
			writer.close();
		} catch (IOException e) {
			logger.error("消息发送失败", e);
		}
	}

	/**
	 * 将文本消息转成XML
	 * 
	 * @param textMessage
	 * @return
	 */
	private String textMessageToXml(RespTextMessage textMessage) {
		XStream xs = new XStream();
		xs.alias("xml", textMessage.getClass());
		return xs.toXML(textMessage);
	}
}
