package com.pabomenendez.webapp.biblioteca.service;

import java.util.List;

import com.pabomenendez.webapp.biblioteca.model.Libro;

public interface ILibroService {
    public List<Libro> listarLibros();

    public Libro buscarLibro(Long id);

    public Libro guardarLibro(Libro libro);

    public void eliminarLibro(Libro libro);
    
}
