package com.user.configuration;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.alibaba.fastjson.JSON;
import com.user.entity.Uproduct;

public class UserDecoder implements Encoder.Text<Uproduct>{

	@Override
	public void init(EndpointConfig endpointConfig) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(Uproduct object) throws EncodeException {
		// TODO Auto-generated method stub
		return JSON.toJSONString(object);
	}


}
