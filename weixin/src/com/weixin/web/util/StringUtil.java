package com.weixin.web.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

public class StringUtil {

	private static final String WEIXIN_TOKEN = "hzz";

	private StringUtil() {

	}

	/**
	 * 验证消息是否来自微信服务器
	 * 
	 * @param encryptionSignature
	 *            sha1加密签名
	 * @param signature
	 *            微信加密签名
	 * @return
	 */
	public static boolean checkSignature(String encryptionSignature, String signature) {
		if (encryptionSignature == null || signature == null) {
			return false;
		} else if (signature.equals(encryptionSignature)) {
			return true;
		}
		return false;
	}

	/**
	 * 返回sha1加密的字符串
	 * 
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @return 加密签名
	 */
	public static String getEncryptionSignature(String signature, String timestamp, String nonce) {
		List<String> lists = new ArrayList<String>();
		lists.add(timestamp);
		lists.add(nonce);
		lists.add(WEIXIN_TOKEN);
		Collections.sort(lists);
		String sha1Hex = DigestUtils.sha1Hex(lists.get(0) + lists.get(1) + lists.get(2));
		return sha1Hex;
	}

}
