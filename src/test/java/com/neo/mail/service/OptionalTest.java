package com.neo.mail.service;

import com.neo.mail.domain.model.MailUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalTest {
	
	@Test
	public void testOptional() {
		MailUser user = new MailUser();
		user.setUsername("jarvis");
		Optional<MailUser> optional = Optional.of(user);
		System.out.println(optional.map(MailUser::getUsername).map(String::toLowerCase).orElse("hello world"));
		System.out.println(optional.filter(str -> str.getUsername().contains("..")).map(MailUser::getUsername).map(String::toUpperCase).orElse(null));
	}
}
