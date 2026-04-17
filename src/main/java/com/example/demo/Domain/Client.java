package com.example.demo.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "oauth_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientId;
    private String clientSecret;
    private String scope;
    private boolean active;

    // 🔹 No-Args Constructor
    public Client() {
    }

    // 🔹 All-Args Constructor
    public Client(Long id, String clientId, String clientSecret, String scope, boolean active) {
        this.id = id;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scope = scope;
        this.active = active;
    }

    // 🔹 Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}