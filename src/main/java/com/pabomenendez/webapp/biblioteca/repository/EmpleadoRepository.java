package com.pabomenendez.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabomenendez.webapp.biblioteca.model.Empleado;

public interface EmpleadoRepository extends JpaRepository <Empleado,Long> {

}
