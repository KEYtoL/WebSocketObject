package com.user.controller;

import java.io.IOException;

import javax.websocket.Decoder;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.user.configuration.UserDecoder;
import com.user.configuration.UserEncoder;
import com.user.sender.UserSender;
import com.user.utils.WebSocketUtil;

@RestController
@ServerEndpoint(value="/user/{userName}",decoders= {UserEncoder.class},encoders= {UserDecoder.class})
public class UserController {

	private static UserSender userSender;

	@Autowired
	public void setUserSender(UserSender userSender) {
		UserController.userSender = userSender;
	}

	@OnOpen
	public void getOne(@PathParam("userName") String userName, Session session) {
		System.out.println("开始请求发送");
		if (!WebSocketUtil.MESSAGEMAP.containsKey(userName)) {
			try {
				userSender.send(userName);
				System.out.println("发送成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("发送失败");
			}
			WebSocketUtil.MESSAGEMAP.put(userName, session);
			WebSocketUtil.sendMessage2(session, userName);
		}
		
	}
	
	
	//连接异常
	@OnError
	public void onError(Session session,Throwable throwable) {
		System.out.println("11112312");
		try {
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
