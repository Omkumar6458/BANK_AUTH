package com.example.demo.Service;



import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.User;
import com.example.demo.Repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepo;

    // 🔹 Manual constructor (replacement of @RequiredArgsConstructor)
    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User authenticate(String username) {

        return userRepo.findByUsername(username)
                .filter(User::isEnabled)
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));
    }
}







