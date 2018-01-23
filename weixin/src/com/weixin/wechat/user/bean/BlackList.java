package com.weixin.wechat.user.bean;

/**
 * 黑名单列表
 * 
 * @author 黄中正
 *
 */
public class BlackList {

	private Integer id;

	private String openId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Override
	public String toString() {
		return "BlackList [id=" + id + ", openId=" + openId + "]";
	}

}
