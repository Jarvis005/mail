package com.neo.mail.controller;


import com.neo.mail.bean.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/get1")
	public ResultBean get1() {
		logger.info("get1");
		return new ResultBean("get1 ok");
	}
	
	/**
	 *  为什么会发生跨域安全问题:
	 1、浏览器限制：浏览器发现请求存在跨域时，会进行相应校验，校验不通过就会发生跨域安全问题
	 2、跨域, 域名或者端口不一致
	 3、XHR（XMLHttpRequest）请求--不会发生跨域问题
	 
	 解决思路:
	 1、浏览器：加入相应参数让浏览器认为可以跨域
	 2、XHR：JSONP
	 3、跨域：因为目前1/2无法完美解决开发需求
	 （1）、被调用方：支持跨域
	 （2）、调用方：隐藏跨域
	 */
}
