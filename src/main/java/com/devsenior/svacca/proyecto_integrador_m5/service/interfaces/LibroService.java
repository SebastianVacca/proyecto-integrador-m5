package com.devsenior.svacca.proyecto_integrador_m5.service.interfaces;

import java.util.List;

import com.devsenior.svacca.proyecto_integrador_m5.model.Libro;

public interface LibroService {
    
    Libro crearLibro(Libro libro);

    List<Libro> listarLibros();

    Libro libroPorId(Long id);

    Libro actualizarLibro(Long id, Libro libro);

    void eliminarLibro(Long id);

    List<Libro> librosConCoincidencia(String texto);
}
