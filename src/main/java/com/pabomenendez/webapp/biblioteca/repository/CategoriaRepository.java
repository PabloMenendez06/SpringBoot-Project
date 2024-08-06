package com.pabomenendez.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabomenendez.webapp.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
