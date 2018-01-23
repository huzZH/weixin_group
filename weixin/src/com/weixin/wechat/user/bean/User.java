package com.weixin.wechat.user.bean;

public class User {
	//主键ID
	private Integer id;
	//用户的标识，对当前公众号唯一
	private String openId;
	//用户的昵称
	private String nickName;
	//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private Integer sex;
	//用户所在城市
	private String city;
	//用户所在国家
	private String country;
	//用户所在省份
	private String province;
	//用户的语言，简体中文为zh_CN
	private String language;
	//用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	private String headImgUrl;
	//用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	private Integer subScribe;
	//用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	private String subScribeTime;
	//只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
	private String unionId;
	//公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	private String remark;
	//用户所在的分组ID（兼容旧的用户分组接口）
	private Integer groupId;
	//用户被打上的标签ID列表
	private Integer tagIdList;

	
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public Integer getSubScribe() {
		return subScribe;
	}

	public void setSubScribe(Integer subScribe) {
		this.subScribe = subScribe;
	}

	public String getSubScribeTime() {
		return subScribeTime;
	}

	public void setSubScribeTime(String subScribeTime) {
		this.subScribeTime = subScribeTime;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getTagIdList() {
		return tagIdList;
	}

	public void setTagIdList(Integer tagIdList) {
		this.tagIdList = tagIdList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", openId=" + openId + ", nickName=" + nickName + ", sex=" + sex + ", city=" + city
				+ ", country=" + country + ", province=" + province + ", language=" + language + ", headImgUrl="
				+ headImgUrl + ", subScribe=" + subScribe + ", subScribeTime=" + subScribeTime + ", unionId=" + unionId
				+ ", remark=" + remark + ", groupId=" + groupId + ", tagIdList=" + tagIdList + "]";
	}
	
	
	
}
