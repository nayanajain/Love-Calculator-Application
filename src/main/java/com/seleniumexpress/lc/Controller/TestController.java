package com.seleniumexpress.lc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seleniumexpress.api.UserInfoDTO;
import com.seleniumexpress.lc.service.LcAppService;

@Controller
public class TestController { 
	
		
		
	@RequestMapping("/test")
	public String sayHello() {
		
	 
	
	
	return "HelloWorld";
	
	}

}
