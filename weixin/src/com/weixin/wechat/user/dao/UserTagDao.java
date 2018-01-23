package com.weixin.wechat.user.dao;

import java.util.List;

import com.weixin.wechat.user.bean.UserTag;

public interface UserTagDao {
	
	public UserTag selectTagById(Integer tagId);
	
	public List<UserTag> selectTagList();
}
