package com.pabomenendez.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabomenendez.webapp.biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}