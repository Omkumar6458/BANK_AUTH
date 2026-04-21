package com.example.demo.EventListener;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.demo.Domain.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.OTPService;
import com.example.demo.Service.SmsService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OtpLOginSuccessHandler implements AuthenticationSuccessHandler{
	
	
	private final SmsService smsService;
	private final OTPService otpSevice;
	private final EmailService emailService;
	
	
	
	private final UserRepository userRepo;
	
	
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		
		
		String userName = authentication.getName();
	User user = userRepo.findByUsername(userName).orElseThrow( () -> new RuntimeException("User not found"));
	
       String otp =	otpSevice.generatedOtp(userName);
       if(user.getPhoneNumber() != null)
       {
    	   smsService.sendOtp(user.getPhoneNumber(), otp);
       }
       
       if(user.getEmail() != null)
       {
    	   emailService.sendOtp(user.getEmail(), otp);
       }
       
       
       
		
	}
 
	
	
	
	
	
}

/*


@Component is used for automatic bean detection via classpath scanning, while
 @Bean is used for explicitly defining beans with full control over their creation inside a configuration class
*/




