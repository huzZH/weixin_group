package com.weixin.web.start;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.weixin.web.task.MenuTask;
import com.weixin.web.task.WeChatTask;

/**
 * WeChat容器
 * 
 * @author 黄中正
 *
 */
public class WeChatContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		InterfaceUrlManagment.initInterfaceURL();
		
		WeChatTask weChatTask = WeChatTask.getInstance();
		weChatTask.getAccessToken();
		
		MenuTask menuTask = MenuTask.getInstance();
		menuTask.initMenu();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		/*InterfaceUrlManagment.destroyed();*/
	}

}
