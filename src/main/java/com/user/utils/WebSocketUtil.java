package com.user.utils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;
import javax.websocket.EncodeException;
import javax.websocket.RemoteEndpoint;
public class WebSocketUtil {
	//HashMap：不支持多线程，并发情况下线程不安全
	public static final Map<String, Session> MESSAGEMAP = new ConcurrentHashMap<>();
	

	//发送消息给客户端
	public static void sendMessage(Session session,Object data) throws EncodeException {
		if (session!=null) {
			final RemoteEndpoint.Basic basic = session.getBasicRemote();
			if (basic!=null) {
				try {
					basic.sendObject(data);//发送消息回客户端
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//发送消息给客户端
	public static void sendMessage2(Session session,String message)  {
		if (session!=null) {
			final RemoteEndpoint.Basic basic = session.getBasicRemote();
			if (basic!=null) {
				try {
					basic.sendText(message);//发送消息回客户端
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
