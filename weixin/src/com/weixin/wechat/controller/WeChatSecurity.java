package com.weixin.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.weixin.web.util.StringUtil;

@Controller
@RequestMapping(value = "/weixin")
public class WeChatSecurity {

	private Logger logger = Logger.getLogger(WeChatSecurity.class);

	/**
	 * 验证消息是否来自微信服务器
	 * 
	 * @param signature
	 *            微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @param echostr
	 *            随机字符串
	 */
	@RequestMapping(value = "/security", method = RequestMethod.GET)
	public void validateWechat(HttpServletResponse response,
			@RequestParam(value = "signature", required = true) String signature,
			@RequestParam(value = "timestamp", required = true) String timestamp,
			@RequestParam(value = "nonce", required = true) String nonce,
			@RequestParam(value = "echostr", required = true) String echostr) {

		String encryptionSignature = StringUtil.getEncryptionSignature(signature, timestamp, nonce);
		boolean result = StringUtil.checkSignature(encryptionSignature, signature);

		try {
			if (result) {
				PrintWriter writer = response.getWriter();
				writer.write(echostr);
				writer.flush();
				writer.close();
			} else {
				logger.info("验证消息失败 signature: " + signature + "timestamp: " + timestamp + "nonce: " + nonce
						+ "echostr: " + echostr + "encryptionSignature: " + encryptionSignature);
			}
		} catch (IOException e) {
			logger.error("返回服务器消息 signature: " + signature + "timestamp: " + timestamp + "nonce: " + nonce + "echostr: "
					+ echostr, e);
		}

	}
}
