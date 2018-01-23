package com.weixin.web.handle;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

@Component
public class XmlResolveHandler {
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> parseXmlToMap(HttpServletRequest request) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		InputStream inputStream = request.getInputStream();
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		Element root = document.getRootElement();
		
		List<Element> elements = root.elements();
		for (Element el : elements) {
			map.put(el.getName(), el.getText());
		}
		inputStream.close();
		inputStream = null;
		return map;
	}
}
