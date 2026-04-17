package com.example.demo.Controller;





import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AuditService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final AuditService auditService;

    // 🔹 Manual Constructor Injection (instead of @RequiredArgsConstructor)
    public LoginController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping("/login-success")
    public void loginSuccess(@RequestParam String userName,
                             HttpServletRequest request) {

        auditService.logSuccess(userName, request.getRemoteAddr());
    }

    @PostMapping("/login-failure")
    public void loginFailure(@RequestParam String userName,
                             @RequestParam String reason,
                             HttpServletRequest request) {

        auditService.logFailure(userName, request.getRemoteAddr(), reason);
    }
}







