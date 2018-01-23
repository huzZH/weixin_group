package com.weixin.web.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.weixin.web.config.GlobalConstant;
import com.weixin.web.config.InterfaceURL;
import com.weixin.web.config.WeChatConfig;
import com.weixin.web.service.AbstractMenuService;
import com.weixin.web.util.HttpUtil;

@Service
public class MenuServiceImpl extends AbstractMenuService {

	private static Logger logger = Logger.getLogger(HttpUtil.class);

	/**
	 * 创建一级菜单
	 * 
	 * @param buttons
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void createMainMenu(String param) {

		String createMenuURL = GlobalConstant.getInterfaceUrl(InterfaceURL.CREATE_MENU_URL);
		String access_token = GlobalConstant.getInterfaceUrl(WeChatConfig.ACCESS_TOKEN);
		String regUrl = createMenuURL + access_token;
		String result;
		try {
			result = HttpUtil.sendPostJsonStrRequest(regUrl, param);
			Gson gson = new Gson();
			Map<Object, Object> resMap = gson.fromJson(result, Map.class);
			
			
			if (resMap.get("errcode").equals(0)) {
				logger.info("主菜单创建成功errcode:" + resMap.get("errcode") + "errmsg:" + resMap.get("errmsg"));
			} else {
				logger.error("主菜单创建失败errcode:" + resMap.get("errcode") + "errmsg:" + resMap.get("errmsg"));
			}
		} catch (Exception e) {
			logger.error("请求异常, 请求URL:" + regUrl + "请求参数：" + param, e);
		}
	}

	/**
	 * 查询自定义菜单
	 * 
	 */
	@Override
	public void queryMenu() {
		String queryMenuUrl = GlobalConstant.getInterfaceUrl(InterfaceURL.QUERY_MENU_URL);
		String regUrl = queryMenuUrl + GlobalConstant.getInterfaceUrl(WeChatConfig.ACCESS_TOKEN);
		
		String result = HttpUtil.sendGetRequest(regUrl, null);
		
		logger.info("自定义菜单返回结果 " + result);
	}
	
	@SuppressWarnings("unchecked")
	public void deleteMenu() {
		String queryMenuUrl = GlobalConstant.getInterfaceUrl(InterfaceURL.DELETE_MENU_URL);
		String regUrl = queryMenuUrl + GlobalConstant.getInterfaceUrl(WeChatConfig.ACCESS_TOKEN);
		
		String result = HttpUtil.sendGetRequest(regUrl, null);
		Gson gson = new Gson();
		Map<String, String> resMap = gson.fromJson(result, Map.class);
		if ("0".equals(resMap.get("errcode"))) {
			logger.info("删除菜单成功 errcode:" + resMap.get("errcode") + "errmsg:" + resMap.get("errmsg"));
		} else {
			logger.error("删除菜单失败 errcode:" + resMap.get("errcode") + "errmsg:" + resMap.get("errmsg"));
		}
		
		
		logger.info("自定义菜单返回结果" + result);
	}

}
