package com.pabomenendez.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabomenendez.webapp.biblioteca.model.Prestamo;
import com.pabomenendez.webapp.biblioteca.repository.PrestamoRepository;

@Service
public class PrestamoService implements IPrestamoService{

    @Autowired
    PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo buscarPrestamoPorId(Long id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    @Override
    public Prestamo guardarPrestamo(Prestamo prestamo) {
    return prestamoRepository.save(prestamo);
    }

    @Override
    public void eliminarPrestamo(Prestamo prestamo) {
        prestamoRepository.delete(prestamo);
    }

    @Override
    public boolean tienePrestamoVigente(Long dpi) {
        List<Prestamo> prestamos = prestamoRepository.findAll();

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCliente() != null && prestamo.getCliente().getDpi().equals(dpi) &&  prestamo.getVigencia()) {
                return true;
            }
        }
        return false;
    }

}
