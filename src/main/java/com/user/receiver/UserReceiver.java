package com.user.receiver;

import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.user.entity.Uproduct;
import com.user.utils.WebSocketUtil;

@Component
@RabbitListener(queues="uproductQueue")
public class UserReceiver {
	@RabbitHandler
	public void received(Uproduct uproduct) throws EncodeException {
		System.out.println("接收到数据");
		System.out.println(uproduct);
		Set<String> keySet = WebSocketUtil.MESSAGEMAP.keySet();
		
		for (String string : keySet) {
			Session session = WebSocketUtil.MESSAGEMAP.get(string);
			WebSocketUtil.sendMessage(session, uproduct);
			System.out.println("发送11111成功");
		}
	}
}
