package com.pabomenendez.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabomenendez.webapp.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository <Libro,Long>{

}
