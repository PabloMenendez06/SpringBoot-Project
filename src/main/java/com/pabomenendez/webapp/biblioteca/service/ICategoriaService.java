package com.pabomenendez.webapp.biblioteca.service;

import java.util.List;
import com.pabomenendez.webapp.biblioteca.model.Categoria;

public interface ICategoriaService {

    public List<Categoria> listarCategorias();

    public void guardarCategoria(Categoria categoria);

    public Categoria buscarCategoriaPorId(Long id);

    public void eliminarCategoria(Categoria categoria);
}
