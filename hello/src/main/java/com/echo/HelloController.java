package com.echo;

import static org.mockito.Mockito.RETURNS_MOCKS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value="/say/{id}",method=RequestMethod.GET)
	public String  say(@PathVariable("id") Integer id) {
//		return girlProperties.getCupSize();
//		return "index";
		return "id:"+id;
	}
	
//	@RequestMapping(value="/say2",method=RequestMethod.GET)
	@GetMapping(value="/say2")
	public String  say2(@RequestParam(value="id",required=false,defaultValue="0") Integer id) {
		return "id:"+id;
	}
}
