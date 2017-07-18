package com.echo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
@RequestMapping(value={"/hello","/hi"})
public class HelloController {
//	@Value("${cupSize}")
//	private String cupSize;
//	@Value("${age}")
//	private String age;
//	@Value("${content}")
//	private String content;
	@Autowired
	private GirlProperties girlProperties;

	@RequestMapping(value="/say",method=RequestMethod.GET)
	public String  say() {
		return girlProperties.getCupSize();
//		return "index";
	}
}
