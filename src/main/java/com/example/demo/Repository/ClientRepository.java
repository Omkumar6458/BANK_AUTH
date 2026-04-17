package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByClientId(String client);
}
