package com.sms.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.message.module.SmsModule;
import com.sms.message.service.SmsService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	SmsService smsService;
	
	@PostMapping(value = "telspielmessage", produces = MediaType.APPLICATION_JSON_VALUE)
	public String telspielSms(@RequestBody SmsModule smsModule) {
		return smsService.getTelspielSms(smsModule);
		
	}

}
