package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Audit.LoginAuditEntity;

public interface LoginAuditRepository extends JpaRepository<LoginAuditEntity, Long> {

}
