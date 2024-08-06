package com.pabomenendez.webapp.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Cliente")

public class Cliente {

    @Id
    private long dpi;
    private String nombre;
    private String apellido;
    private String telefono;

}