package com.weixin.wechat.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.wechat.user.bean.User;
import com.weixin.wechat.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 根据用户openid查找用户信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/selectUserById")
	@ResponseBody
	public User queryUserById(@RequestParam(value = "openId", required = true) Integer openId) {

		return userService.selectUserById(openId);
	}

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */ 
	@RequestMapping(value = "/selectUserList")
	@ResponseBody
	public List<User> queryUserList() {
		List<User> selectUserList = userService.selectUserList();
		return selectUserList;
	}

	/**
	 * 将用户拉入黑名单
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/blockedToList")
	@ResponseBody
	public void blockedList(@RequestParam(value = "openId", required = true) Integer openId) {
		userService.blockedList(openId);
	}
}
