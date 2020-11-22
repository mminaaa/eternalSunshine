package org.movie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		List<Map<String, String>> list = getYoutubeList();
		
		model.addAttribute("list", list);
		
		return "main/home";
	}
	
	
	
	private List<Map<String, String>> getYoutubeList() {
		
		String url = "https://rss.app/feeds/d5FESJMiaJaj7HW6.xml";
		
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> map;
		
		try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(url);		// 파싱
		doc.getDocumentElement().normalize();	// 정규화
		
		NodeList nList =doc.getElementsByTagName("item");
		
		Element el = null;
		NodeList subList = null;
			Element subEl = null;
			Node txt = null;
			String value = "";
			String tagName = "";
			String[] tagList = {"title","link","media:content"};
			
			
			for (int i = 0; i < nList.getLength(); i++) {
				el = (Element) nList.item(i);
				map = new HashMap<String, String>();
				
				
				for (int j = 0; j < tagList.length; j++) {
					subList = el.getElementsByTagName(tagList[j]);
					
					for (int k = 0; k < subList.getLength(); k++) {
						subEl = (Element) subList.item(k);
						String tagUrl = subEl.getAttribute("url");
						
						tagName = subEl.getTagName();
						if (tagName.equals("media:content")) {
							tagName = "imageUrl";
						}
						txt = subEl.getFirstChild();
						
						if (txt != null) {
							value = txt.getNodeValue();
						}else {
							value = tagUrl;
						}
					}
					map.put(tagName, value);
				}
				
				list.add(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
