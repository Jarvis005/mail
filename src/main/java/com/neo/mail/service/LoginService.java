package com.neo.mail.service;

import com.neo.mail.domain.model.MailUser;

import java.util.List;

public interface LoginService {
	
	void add (MailUser user);
	
	MailUser findByName(String username);
	
	List<MailUser> listAll();
	
	void deleteById(Long id);
	
	MailUser findById(Long id);
}
