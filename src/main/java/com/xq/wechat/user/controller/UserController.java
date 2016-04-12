package com.xq.wechat.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public Map<String, Object> test(){
		Map<String, Object> tMap = new HashMap<String, Object>();
		tMap.put("teswt", "trewsdf");
		return tMap;
	}
	
	@RequestMapping("/tpage")
	public String page(){
		LOGGER.info("---------------------------------------------test");
		return "test";
	}
}
