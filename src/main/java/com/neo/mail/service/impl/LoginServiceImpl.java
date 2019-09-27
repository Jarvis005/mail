package com.neo.mail.service.impl;

import com.alibaba.fastjson.JSON;
import com.neo.mail.domain.enums.DeleteFlagEnum;
import com.neo.mail.domain.enums.EnabledEnum;
import com.neo.mail.domain.model.MailUser;
import com.neo.mail.mapper.MailUserMapper;
import com.neo.mail.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
	
	private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	private MailUserMapper mailUserMapper;
	
	@Override
	public void add(MailUser user) {
		logger.info("register 入参：{}", JSON.toJSONString(user));
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		user.setCreateTime(new Date());
		user.setDeleteFlag(DeleteFlagEnum.zero.getCode());
		user.setEnabled(EnabledEnum.zero.getCode());
		mailUserMapper.insert(user);
	}
	
	@Override
	public MailUser findByName(String username) {
		logger.info("根据用户名查找用户， 用户名:{}", username);
		return mailUserMapper.findByUserName(username);
	}
	
	@Override
	public List<MailUser> listAll() {
		return mailUserMapper.listUsers();
	}
	
	@Override
	public void deleteById(Long id) {
		mailUserMapper.delete(id);
	}
	
	@Override
	public MailUser findById(Long id) {
		return mailUserMapper.findById(id);
	}
}
