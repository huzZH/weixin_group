package com.weixin.wechat.user.service;

import java.util.List;

import com.weixin.wechat.user.bean.User;

public interface UserService {

	public User selectUserById(Integer id);

	public List<User> selectUserList();

	public void blockedList(Integer openId);
}
