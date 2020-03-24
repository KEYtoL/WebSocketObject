package com.user.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


@Configuration
public class UserConfiguration {
	
	@Bean 
	public Queue userQueue() {
		Queue queue = new Queue("userQueue");
		return queue;
		
	}
	
	@Bean 
	public FanoutExchange userExchange() {
		return new FanoutExchange("userExchange");
	}
	
	@Bean
	public Binding userBinding(Queue userQueue,FanoutExchange userExchange) {
		return BindingBuilder.bind(userQueue).to(userExchange);
	}
	
	@Bean    //在容器中创建bean对象，在WebSocketUtil中需要用到的RemoteEndpoint对象
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
	

}
