package com.neo.mail.mapper;

import com.neo.mail.domain.model.MailUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailUserMapper {
	void insert(MailUser user);
	
	void delete(Long id);
	
	void updateOfNull(MailUser user);
	
	List<MailUser> listUsers();
	
	MailUser findByUserName(String username);
	
	MailUser findById(Long id);
}
