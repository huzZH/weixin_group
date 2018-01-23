package com.weixin.wechat.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weixin.wechat.user.bean.User;
import com.weixin.wechat.user.dao.UserDao;
import com.weixin.wechat.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public User selectUserById(Integer openId) {
		User user = userDao.selectUserById(openId);
		System.out.println(user.toString());
		return user;
	}

	@Override
	public List<User> selectUserList() {
		return userDao.selectUserList();
	}

	@Override
	public void blockedList(Integer openId) {
		// TODO Auto-generated method stub
		userDao.blockedList(openId);
	}
}
