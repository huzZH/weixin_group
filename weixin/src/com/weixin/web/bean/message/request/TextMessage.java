package com.weixin.web.bean.message.request;

/**
 * 文本消息
 * 
 * @author 黄中正
 *
 */
public class TextMessage extends BaseMessage {

	private String Content; // 文本

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "TextMessage [" + "ToUserName=" + super.getToUserName() + ", FromUserName=" + super.getFromUserName()
				+ ", CreateTime=" + super.getCreateTime() + ", MsgType=" + super.getMsgType() + ", MsgId="
				+ super.getMsgId() + "Content=" + Content + "]";
	}

}
