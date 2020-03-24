package com.user.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSender {
	@Autowired
	private AmqpTemplate amqpTemplate;
	public void send(String uname) {
		System.out.println("进入发送");
		String pid = "1002";
		amqpTemplate.convertAndSend("userQueue",pid);
	}
}
