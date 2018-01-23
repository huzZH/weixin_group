package com.weixin.web.handle.msghandle;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.weixin.web.bean.message.request.ImageMessage;
import com.weixin.web.bean.message.response.Image;
import com.weixin.web.bean.message.response.RespImageMessage;

@Component
public class ReqImageMsgHandler extends AbstractMsgHandler {

	private static Logger logger = Logger.getLogger(ReqImageMsgHandler.class);

	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				boolean cdata = true;

				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
	/**
	 * 发送图片消息
	 * @param xmlMap
	 * @param response
	 */
	@Override
	public void handleMsg(Map<String, String> xmlMap, HttpServletResponse response) {
		String toUserName = xmlMap.get("ToUserName");
		String fromUserName = xmlMap.get("FromUserName");
		Long createTime = Long.valueOf(xmlMap.get("CreateTime"));
		String msgType = xmlMap.get("MsgType");
		String picUrl = xmlMap.get("PicUrl");
		String mediaId = xmlMap.get("Medi aId");
		Long msgId = Long.valueOf(xmlMap.get("MsgId"));

		ImageMessage imageMsg = new ImageMessage();
		imageMsg.setToUserName(toUserName);
		imageMsg.setFromUserName(fromUserName);
		imageMsg.setCreateTime(createTime);
		imageMsg.setMsgType(msgType);
		imageMsg.setPicUrl(picUrl);
		imageMsg.setMediaId(mediaId);
		imageMsg.setMsgId(msgId);

		sendMsg(response, imageMsg);
	}
	/**
	 * 发送图片消息
	 * @param response
	 * @param imageMessage
	 */
	private void sendMsg(HttpServletResponse response, ImageMessage imageMessage) {
		RespImageMessage respImageMsg = new RespImageMessage();

		respImageMsg.setToUserName(imageMessage.getFromUserName());
		respImageMsg.setFromUserName(imageMessage.getToUserName());
		respImageMsg.setCreateTime(imageMessage.getCreateTime());
		respImageMsg.setMsgType(imageMessage.getMsgType());
		String mediaId = "v2QwjBLY9mP9Bo6tFKL8kTxnGFiAHSx3QwRcUXqAfeLwHtXxMFJTkxyBSpltIu3j";
		respImageMsg.setImage(new Image(mediaId));

		String imageMessageToXml = imageMessageToXml(respImageMsg);
		logger.info("发送消息: " + imageMessageToXml);
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(imageMessageToXml);
			writer.close();
		} catch (IOException e) {
			logger.error("发送消息失败", e);
		}
	}
	/**
	 * 图片消息转成XML格式
	 * @param imageMessage
	 * @return
	 */
	public static String imageMessageToXml(RespImageMessage imageMessage) {
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
}
