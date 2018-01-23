package com.weixin.wechat.user.bean;

/**
 * 用户标签
 * 
 * @author 黄中正
 *
 */
public class UserTag {
	// 标签id，由微信分配
	private Integer tagId;
	// 标签名，UTF8编码
	private String tagName;

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + "]";
	}

}
