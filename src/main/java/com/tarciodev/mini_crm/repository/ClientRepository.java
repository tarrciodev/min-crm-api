package com.tarciodev.mini_crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarciodev.mini_crm.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
