package com.weixin.web.task;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.weixin.web.config.GlobalConstant;
import com.weixin.web.config.InterfaceURL;
import com.weixin.web.config.WeChatConfig;
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
		params.put("appid", GlobalConstant.getInterfaceUrl(WeChatConfig.APPID));
		params.put("secret", GlobalConstant.getInterfaceUrl(WeChatConfig.APPSECRET));
		String result = HttpUtil.sendGetRequest(tokenURL, params);
		Gson gson = new Gson();
		Map<Object, Object> resMap = gson.fromJson(result, Map.class);

		if (resMap.containsKey("errcode")) {
			logger.error("errcode:" + resMap.get("errcode") + " errmsg:" + resMap.get("errmsg"));
			return;
		}

		Object access_token = resMap.get(WeChatConfig.ACCESS_TOKEN);
		Object expires_in = resMap.get(WeChatConfig.EXPIRES_IN);
		GlobalConstant.interfaceUrlProperties.put(WeChatConfig.ACCESS_TOKEN, access_token);
		logger.info(DateUtil.getNowTime() + "状态码expires_in:" + expires_in + "获取的access_tokn:" + access_token);
	}
}
