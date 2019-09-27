package com.neo.mail.controller;

import com.neo.mail.bean.JsonResult;
import com.neo.mail.domain.form.MessageForm;
import com.neo.mail.domain.model.MailUser;
import com.neo.mail.service.LoginService;
import com.neo.mail.service.MailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private MailService mailService;
	
	
	@RequestMapping("/mail")
	public String mail (ModelMap modelMap) {
		return "mail/mail";
	}
	
	@RequestMapping("addressBook")
	public String addressBook (ModelMap modelMap) {
		List<MailUser> userList = loginService.listAll();
		modelMap.addAttribute("userList", userList);
		return "mail/addressBook";
	}
	@RequestMapping("writeMessage")
	public String writeMessage (ModelMap modelMap) {
		return "mail/writeMessage";
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public JsonResult delete (@RequestParam("id") Long id) {
		if (id == null) {
			return JsonResult.createFailJsonResult("参数错误");
		}
		MailUser user = loginService.findById(id);
		loginService.deleteById(id);
		return JsonResult.createSuccessJsonResult(user.getUsername() + "删除成功");
	}
	
	@RequestMapping("upload")
	@ResponseBody
	public JsonResult upload () {
		return JsonResult.createSuccessJsonResult("上传成功");
	}
	
	@RequestMapping("sendMsg")
	@ResponseBody
	public JsonResult sendMsg(@RequestBody MessageForm form) {
		String receiveUser = form.getReceiveUser();
		String target = form.getTarget();
		String msgContent = form.getMsgContent();
		if (StringUtils.isEmpty(receiveUser) || StringUtils.isEmpty(target) || StringUtils.isEmpty(msgContent)) {
			return JsonResult.createFailJsonResult("参数错误");
		}
		mailService.sendSimpleMail(receiveUser, target, msgContent);
		return JsonResult.createSuccessJsonResult("发送成功");
	}
}
