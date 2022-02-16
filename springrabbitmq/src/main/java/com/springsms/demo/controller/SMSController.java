package com.springsms.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsms.demo.model.SMSModel;
import com.springsms.demo.service.SMSService;

@RestController
@RequestMapping("/twilio")
public class SMSController {
	
	@Autowired
	SMSService smsService;
	
	@PostMapping("/sendSMS")
	public String sendSMS(@RequestBody SMSModel model) {
		System.out.println("Inside sendSMS......");
		return smsService.sendSMS(model);
		
	}

}
