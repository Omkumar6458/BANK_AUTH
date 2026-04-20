package com.example.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.User;
import com.example.demo.Service.UserService;
import com.example.demo.dto.RegisterRequest;




@RestController
@RequestMapping("/user")
public class User_Controller {
   
    private final UserService userService; 

    //  Manual constructor (IMPORTANT)
    public User_Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
    	
    	  System.out.println("🔥 REGISTER API HIT");
        return userService.register(request);
    }
    
}








