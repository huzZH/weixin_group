package com.weixin.web.start;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.weixin.web.config.GlobalConstant;

/**
 * 初始化
 * 
 * @author 黄中正
 *
 */
public class InterfaceUrlManagment {

	private static Logger logger = Logger.getLogger(InterfaceUrlManagment.class);

	/**
	 * 初始化接口路径
	 */
	public static synchronized void initInterfaceURL() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		if (GlobalConstant.interfaceUrlProperties == null) {
			GlobalConstant.interfaceUrlProperties = new Properties();
		}
		// 获取接口路径地址
		loadResource("property/interface_url.properties", classLoader);
		// 获取微信信息
		loadResource("property/wechat.properties", classLoader);
	}

	/**
	 * 销毁承载资源容器
	 */
	public static void destroyed() {
		GlobalConstant.interfaceUrlProperties = null;
	}

	/**
	 * 加载接口资源文件
	 * 
	 * @param fileName
	 *            文件名
	 * @param classLoader
	 *            类加载器
	 */
	private static void loadResource(String fileName, ClassLoader classLoader) {
		logger.info("准备加载微信资源文件");
		if (fileName == null) {
			logger.info("文件为空");
			return;
		}
		InputStream inputStream = null;
		inputStream = classLoader.getResourceAsStream(fileName);
		logger.info("加载微信资源文件:" + fileName);
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			for (Object key : properties.keySet()) {
				GlobalConstant.interfaceUrlProperties.put(key, properties.get(key));
			}
		} catch (IOException e) {
			logger.error("读取接口路径文件失败, FileName: " + fileName, e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
