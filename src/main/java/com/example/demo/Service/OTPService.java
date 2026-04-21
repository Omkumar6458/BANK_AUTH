package com.example.demo.Service;

import java.time.Duration;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import io.netty.util.internal.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OTPService {
	
	// generated and store :  get from redis and call  to twilio
	
	private final StringRedisTemplate redisTemplate;
	
	public String generatedOtp(String userName) {
		String otp = String.valueOf(ThreadLocalRandom.current().nextInt(100000,999999));
		redisTemplate.opsForValue().set("otp"+userName, otp,Duration.ofMinutes(2));
		return otp;
	}
	
	public boolean verifyOtp(String userName, String otp)
	{
		String storedOtp = redisTemplate.opsForValue().get("otp:"+userName);
		
		if(storedOtp == null)
		{
			return false;
		}
		else {
			return storedOtp.equals(otp);
		}
	}
	
	/**
	 *  now send to what i geberated the otp : 
	 * 
	 */
	
	
	
	
	
	
	
}
