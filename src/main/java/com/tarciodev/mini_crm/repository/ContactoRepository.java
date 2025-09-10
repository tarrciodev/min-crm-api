package com.tarciodev.mini_crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarciodev.mini_crm.model.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    
}
