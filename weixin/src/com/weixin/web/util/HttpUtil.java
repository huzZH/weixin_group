package com.weixin.web.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

public class HttpUtil {

	private static Logger logger = Logger.getLogger(HttpUtil.class);

	/**
	 * Get请求
	 * 
	 * @param regUrl
	 *            接口请求路径
	 * @param params
	 *            请求参数
	 */
	public static String sendGetRequest(String regUrl, Map<String, String> params) {
		HttpGet request = new HttpGet();
		request.setHeader("Accept-Encoding", "gzip");

		HttpClient client = HttpClients.createDefault();
		String uri = buildURI(regUrl, params);

		InputStream inputStream = null;
		try {
			request.setURI(new URI(uri));
			HttpResponse response = client.execute(request);
			inputStream = response.getEntity().getContent();

			return getJsonStringFromGZIP(inputStream);
		} catch (Exception e) {
			logger.error("请求失败,请求路径 URI: " + uri, e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			request.releaseConnection();
		}
		return null;
	}

	/**
	 * 拼接URI
	 * 
	 * @param regUrl
	 * @param params
	 * @return
	 */
	private static String buildURI(String regUrl, Map<String, String> params) {
		StringBuilder builder = new StringBuilder(regUrl);
		for (String key : params.keySet()) {
			builder.append(String.format("%s=%s&", key, params.get(key)));
		}
		String str = builder.toString();
		return str.substring(0, str.length() - 1);
	}

	/**
	 * 解压缩响应的GZIP数据包
	 * 
	 * @param inputStream
	 * @return
	 */
	public static String getJsonStringFromGZIP(InputStream inputStream) {
		String jsonString = null;
		try {
			BufferedInputStream bis = new BufferedInputStream(inputStream);
			bis.mark(2);
			// 取前两个字节
			byte[] header = new byte[2];
			int result = bis.read(header);
			// reset输入流到开始位置
			bis.reset();
			// 判断是否是GZIP格式
			int headerData = getShort(header);
			// Gzip 流 的前两个字节是 0x1f8b
			if (result != -1 && headerData == 0x1f8b) {
				// LogUtil.i("HttpTask", " use GZIPInputStream ");
				inputStream = new GZIPInputStream(bis);
			} else {
				// LogUtil.d("HttpTask", " not use GZIPInputStream");
				inputStream = bis;
			}
			InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");
			char[] data = new char[100];
			int readSize;
			StringBuffer sb = new StringBuffer();
			while ((readSize = reader.read(data)) > 0) {
				sb.append(data, 0, readSize);
			}
			jsonString = sb.toString();
			bis.close();
			reader.close();
		} catch (Exception e) {
			logger.error("响应GZIP压缩包解压失败", e);
			e.printStackTrace();
		}
		return jsonString;
	}

	private static int getShort(byte[] data) {
		return (data[0] << 8) | data[1] & 0xFF;
	}
}
