package com.example.demo.Service;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.RegisterRequest;




@Service
public class UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    //  Manually written constructor
    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request) {

    	User user = new User();
    	user.setUsername(request.getUsername());
    	user.setPassword(passwordEncoder.encode(request.getPassword()));
    	user.setBranchId(request.getBranchId());
    	user.setEmployeeCode(request.getEmployeeCode());
    	
    	

    	return userRepo.save(user);
    }
}



