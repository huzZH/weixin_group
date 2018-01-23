package com.weixin.wechat.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weixin.wechat.user.bean.User;

@Repository
public interface UserDao {

	public void addUser(User user);

	public User selectUserById(int openId);

	public List<User> selectUserList();

	public void blockedList(Integer openId);
}
