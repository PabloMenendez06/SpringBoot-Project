package com.pabomenendez.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabomenendez.webapp.biblioteca.model.Categoria;
import com.pabomenendez.webapp.biblioteca.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
        
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
            categoriaRepository.save(categoria);
    }

    @Override
    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
        
    }

    @Override
    public void eliminarCategoria(Categoria categoria) {
        categoriaRepository.delete(categoria);
        
    }


}
