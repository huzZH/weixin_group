package com.weixin.web.task;

public class QuartzJob {
	
	public void scheduGetToken() {
		WeChatTask weChatTask = WeChatTask.getInstance();
		weChatTask.getAccessToken();
	}
}
