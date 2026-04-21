package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;
import jakarta.annotation.PostConstruct;

import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
    
	@Value("${twilio.sid}") // what set in config file
	private String accountId;
	
	
	@Value("${twilio.token}")
	private String authToken;
	
	@Value("${twilio.number}")
	private String fromNumber;
	
	
	@PostConstruct
	private void init()
	{
		Twilio.init(authToken, accountId);
	}
	
	public void sendOtp(String phone, String otp)
	{
	    Message.creator(new PhoneNumber(phone) , new PhoneNumber(fromNumber), "YOUR OTP BANK "+otp).create();	
	}
	
	

	
}









