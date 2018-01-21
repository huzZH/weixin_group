package com.weixin.wechat.task;

public class QuartzJob {
	
	public void scheduGetToken() {
		WeChatTask weChatTask = WeChatTask.getInstance();
		weChatTask.getAccessToken();
	}
}
