package com.neo.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	
	@Resource
	private MailService mailService;
	
	@Resource
	private TemplateEngine templateEngine;
	
	@Test
	public void mail () {
		mailService.sayHello();
	}
	
	@Test
	public void sendSimpleMail () {
		mailService.sendSimpleMail("QDwenpeng@163.com", "第一封邮件", "大家好，这是我的第一封邮件");
	}
	
	@Test
	public void sendHtmlMail() {
		String content = "<html>\n" +
				"<body>\n" +
				"<h3 style='color: red;'> hello world ， 这是一封html邮件!</h3>" +
				"<img src='http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg' />" +
				"</body>\n" +
				"</html>";
		mailService.sendHtmlMail("QDwenpeng@163.com", "这是一封html邮件", content);
	}
	
	@Test
	public void sendAttachMentMail() {
		String content = "<html>\n" +
				"<body>\n" +
				"<h3 style='color: red;'> hello world ， 这是一封附件邮件!</h3>" +
				"<img src='http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg' />" +
				"</body>\n" +
				"</html>";
		String filePath = "C:\\Users\\EDZ\\Desktop\\设置试点前，查询客户状态.txt";
		mailService.sendAttachmentMail("QDwenpeng@163.com", "这是一封附件邮件", content, filePath);
	}
	
	@Test
	public void sendInlineMentMail() {
		String imgPath = "C:\\Users\\EDZ\\Desktop\\差旅费报销 (2).png";
		String rscId = "neo001";
		String content = "<html>\n" +
				"<body>\n" +
				"<h3 style='color: red;'> hello world ， 这是一封图片邮件!</h3>" +
				"<img src=\'cid:" + rscId + "/\'>" +
				"</body>\n" +
				"</html>";
		mailService.sendInkinResourceMail("QDwenpeng@163.com", "这是一封图片邮件", content, imgPath, rscId);
	}
	
	@Test
	public void templetMailTest () {
		Context context = new Context();
		context.setVariable("id", "006");
		String emailContent = templateEngine.process("emilTemlet", context);
		mailService.sendHtmlMail("QDwenpeng@163.com", "这是一封模板邮件", emailContent);
	}
}
