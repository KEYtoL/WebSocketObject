package com.user.configuration;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.alibaba.fastjson.JSON;
import com.user.entity.Uproduct;

public class UserEncoder implements Decoder.Text<Uproduct>{

	@Override
	public void init(EndpointConfig endpointConfig) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Uproduct decode(String s) throws DecodeException {
		// TODO Auto-generated method stub
		return JSON.parseObject(s,Uproduct.class);
	}

	@Override
	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		return true;
	}


	


}
