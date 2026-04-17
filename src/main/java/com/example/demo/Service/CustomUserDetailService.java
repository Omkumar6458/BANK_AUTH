


package com.example.demo.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.demo.Domain.User;
import com.example.demo.Repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepo;

    // Constructor Injection
    public CustomUserDetailService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // 🔥 MOST IMPORTANT METHOD
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1. Fetch user from DB
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // 2. Convert roles + permissions → authorities
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .flatMap(role -> Stream.concat(
                                // Role
                                Stream.of(new SimpleGrantedAuthority("ROLE_" + role.getName())),

                                // Permissions
                                role.getPermissions().stream()
                                        .map(p -> new SimpleGrantedAuthority(p.getName()))
                        ))
                        .collect(Collectors.toSet())
        );
    }
}