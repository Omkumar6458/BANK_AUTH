
package com.example.demo.Audit;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "login_audit")
public class LoginAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean success;

    private String ipAddress;

    private String reason;

    private LocalDateTime loginTime;  

    // 🔹 No-Args Constructor
    public LoginAuditEntity() {
    }

    // 🔹 All-Args Constructor
    public LoginAuditEntity(Long id, String name, boolean success, String ipAddress, String reason, LocalDateTime loginTime) {
        this.id = id;
        this.name = name;
        this.success = success;
        this.ipAddress = ipAddress;
        this.reason = reason;
        this.loginTime = loginTime;
    }

    // 🔹 Getters & Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
}