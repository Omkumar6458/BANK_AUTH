package com.example.demo.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.Audit.LoginAuditEntity;
import com.example.demo.Repository.LoginAuditRepository;

@Service
public class AuditService {

    private final LoginAuditRepository auditRepo;

    public AuditService(LoginAuditRepository auditRepo) {
        this.auditRepo = auditRepo;
    }

    public void logSuccess(String userName, String ip) {
        LoginAuditEntity audit = new LoginAuditEntity();
        audit.setName(userName);
        audit.setSuccess(true);
        audit.setIpAddress(ip);
        audit.setReason(null);
        audit.setLoginTime(LocalDateTime.now());

        auditRepo.save(audit);
    }

    public void logFailure(String userName, String ip, String reason) {
        LoginAuditEntity audit = new LoginAuditEntity();
        audit.setName(userName);
        audit.setSuccess(false);
        audit.setIpAddress(ip);
        audit.setReason(reason);
        audit.setLoginTime(LocalDateTime.now());

        auditRepo.save(audit);
    }
}







