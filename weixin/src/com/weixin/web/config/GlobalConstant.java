package com.weixin.web.config;

import java.util.Properties;

/**
 * 全局资源容器
 * 
 * @author 黄中正
 *
 */
public class GlobalConstant {

	// 存放全局的接口路径
	public static Properties interfaceUrlProperties;

	/**
	 * 获取接口路径
	 * 
	 * @param key
	 * @return
	 */
	public static String getInterfaceUrl(String key) {
		return (String) interfaceUrlProperties.get(key);
	}
}
