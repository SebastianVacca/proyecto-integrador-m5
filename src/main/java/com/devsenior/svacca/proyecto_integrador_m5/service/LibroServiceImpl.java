package com.devsenior.svacca.proyecto_integrador_m5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.svacca.proyecto_integrador_m5.model.Libro;
import com.devsenior.svacca.proyecto_integrador_m5.repository.LibrosRepository;
import com.devsenior.svacca.proyecto_integrador_m5.service.interfaces.LibroService;

@Service
public class LibroServiceImpl implements LibroService{

    private LibrosRepository librosRepository; 
    
    public LibroServiceImpl(LibrosRepository librosRepository) {
        this.librosRepository = librosRepository;
    }

    
    @Override    
    public Libro crearLibro(Libro libro) {
        librosRepository.save(libro);
        return libro;
    }

    @Override
    public List<Libro> listarLibros() {
        return librosRepository.findAll();
    }

    @Override
    public Libro libroPorId(Long id) {
        return librosRepository.findById(id);
    }

    @Override
    public Libro actualizarLibro(Long id, Libro libro) {
        var libroActualizado = librosRepository.update(id, libro);
        return libroActualizado;
    }

    @Override
    public void eliminarLibro(Long id) {
        librosRepository.deleteById(id);
        System.out.println("Libro eliminado correctamente");
    }

    @Override
    public List<Libro> librosConCoincidencia(String texto) {
        return librosRepository.findContains(texto);
    }
    
}
