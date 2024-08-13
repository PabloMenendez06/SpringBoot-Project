package com.pabomenendez.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabomenendez.webapp.biblioteca.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo,Long>{

}
