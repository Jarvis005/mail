package com.neo.mail.controller;


import com.neo.mail.bean.JsonResult;
import com.neo.mail.domain.model.MailUser;
import com.neo.mail.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping("/toRegister")
	public String toRegister (ModelMap modelMap) {
		return "login/toRegister";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult register (@RequestBody MailUser user) {
		Boolean result = checkUserParam(user);
		if (!result) {
			return JsonResult.createFailJsonResult("参数错误, 请输入用户名、密码");
		}
		MailUser mailUser = loginService.findByName(user.getUsername());
		if (mailUser != null) {
			return JsonResult.createFailJsonResult("用户名已存在,请重新输入");
		}
		loginService.add(user);
		return JsonResult.createSuccessJsonResult("注册成功");
	}
	
	@RequestMapping("/toLogin")
	public String toLogin (ModelMap modelMap) {
		return "login/toLogin";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult login (@RequestBody MailUser user) {
		Boolean result = checkUserParam(user);
		if (!result) {
			JsonResult.createFailJsonResult("参数错误, 请输入用户名、密码");
		}
		MailUser mailUser = loginService.findByName(user.getUsername());
		if (mailUser == null) {
			return JsonResult.createFailJsonResult("用户不存在");
		}
		String password = mailUser.getPassword();
		if (!DigestUtils.md5Hex(user.getPassword()).equals(password)) {
			return JsonResult.createFailJsonResult("用户名、密码错误");
		}
		return JsonResult.createSuccessJsonResult("登录成功");
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult logout () {
		return JsonResult.createSuccessJsonResult("退出成功");
	}
	
	private Boolean checkUserParam(MailUser user) {
		String username = user.getUsername();
		String password = user.getPassword();
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return false;
		}
		return true;
	}
}
