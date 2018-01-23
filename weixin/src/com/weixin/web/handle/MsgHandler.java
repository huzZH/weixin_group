package com.weixin.web.handle;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface MsgHandler {
	
	public void processMessage(String msgType, Map<String, String> xmlMap, HttpServletResponse response);
	
	public void handleMsg(Map<String, String> xmlMap, HttpServletResponse response);
}
