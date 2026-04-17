package com.example.demo.EventListener;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class LoginSuccessEventListener {

    // 🔹 Manual Logger (instead of @Slf4j)
    private static final Logger log = LoggerFactory.getLogger(LoginSuccessEventListener.class);

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event) {
        log.info("Login success user: {}", event.getAuthentication().getName());
    }
}








