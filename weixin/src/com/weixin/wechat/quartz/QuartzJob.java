package com.weixin.wechat.quartz;

public class QuartzJob {
	
	public void scheduGetToken() {
		WeChatTask weChatTask = WeChatTask.getInstance();
		weChatTask.getAccessToken();
	}
}
