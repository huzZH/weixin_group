package com.weixin.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getNowTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date());
	}
}
