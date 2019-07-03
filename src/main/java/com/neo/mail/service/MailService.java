package com.neo.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {
	
	private final Logger logger = LoggerFactory.getLogger(MailService.class);
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sayHello () {
		System.out.println("Hello World");
		
		logger.info("Hello World");
	}
	
	public void sendSimpleMail (String to, String subject, String content) {
		logger.info("发送简单邮件 start   to:{}, subject: {}, content: {}", to, subject, content);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		mailMessage.setFrom(from);
		javaMailSender.send(mailMessage);
		logger.info("发送简单邮件 end");
	}
	
	public void sendHtmlMail (String to, String subject, String content) {
		logger.info("发送html邮件 start   to:{}, subject: {}, content: {}", to, subject, content);
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			helper.setFrom(from);
			javaMailSender.send(message);
			logger.info("发送html邮件成功");
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.info("发送html邮件失败," + e);
		}
	}
	
	public void sendAttachmentMail (String to, String subject, String content, String filePath) {
		logger.info("发送附件邮件  start  to: {}, subject: {}, content: {}, filePath: {}", to, subject, content, filePath);
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			FileSystemResource file = new FileSystemResource(new File(filePath));
			String fileName = file.getFilename();
			helper.addAttachment(fileName, file);
			
			javaMailSender.send(message);
			logger.info("发送附件邮件成功");
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.info("发送附件邮件失败," + e);
		}
	}
	
	public void sendInkinResourceMail (String to, String subject, String content, String rscPath, String rscId) {
		logger.info("发送图片邮件  start  to: {}, subject: {}, content: {}, rscPath: {}, rscId: {}", to, subject, content, rscPath, rscId);
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setFrom(from);
			helper.setSubject(subject);
			helper.setText(content, true);
			FileSystemResource resource = new FileSystemResource(new File(rscPath));
			helper.addInline(rscId, resource);
			javaMailSender.send(message);
			logger.info("发送图片邮件  成功");
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.info("发送图片邮件  失败，" + e);
		}
		
	}
}
