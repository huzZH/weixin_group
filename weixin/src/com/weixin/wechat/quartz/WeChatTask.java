package com.weixin.wechat.quartz;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.weixin.web.common.InterfaceURL;
import com.weixin.web.common.WeChatConstant;
import com.weixin.web.start.GlobalConstant;
import com.weixin.web.util.DateUtil;
import com.weixin.web.util.HttpUtil;

public class WeChatTask {

	private Logger logger = Logger.getLogger(WeChatTask.class);

	private static WeChatTask chatTask = new WeChatTask();
	
	private WeChatTask() {
		
	}
	public static WeChatTask getInstance() {
		return chatTask;
	}
	/**
	 * 获取access_token
	 */
	@SuppressWarnings("unchecked")
	public void getAccessToken() {
		logger.info(DateUtil.getNowTime() + " 获取最新access_token");
		String tokenURL = GlobalConstant.getInterfaceUrl(InterfaceURL.TOKEN_URL);
		Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "client_credential");
		params.put("appid", GlobalConstant.getInterfaceUrl(WeChatConstant.APPID));
		params.put("secret", GlobalConstant.getInterfaceUrl(WeChatConstant.APPSECRET));
		String result = HttpUtil.sendGetRequest(tokenURL, params);
		Gson gson = new Gson();
		Map<Object, Object> resMap = gson.fromJson(result, Map.class);
		Object access_token = resMap.get(WeChatConstant.ACCESS_TOKEN);
		Object expires_in = resMap.get(WeChatConstant.EXPIRES_IN);
		GlobalConstant.interfaceUrlProperties.put(WeChatConstant.ACCESS_TOKEN, access_token);
		logger.info(DateUtil.getNowTime() + "状态码expires_in:" + expires_in + "获取的access_tokn:" + access_token);
	}
}
