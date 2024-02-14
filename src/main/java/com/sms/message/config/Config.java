package com.sms.message.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sms.message.serviceImpl.SmsServiceImpl;

@Configuration
public class Config {
	
	@Bean
	public SmsServiceImpl smsServiceImpl() {
		return new SmsServiceImpl();
	}

}
