package com.devsenior.svacca.proyecto_integrador_m5.service.interfaces;

import java.util.List;

import com.devsenior.svacca.proyecto_integrador_m5.model.Libro;

public interface LibroService {
    
    /**
     * Función en la capa service que se encarga de la comunicación con
     * la capa de persitencia para cumplir con la tarea de crear un libro
     * @param libro
     * @return
     */
    Libro crearLibro(Libro libro);

    /**
     * Función en la capa service que se encarga de la comunicación con
     * la capa de persitencia para cumplir con la tarea de listar toda 
     * la colección de libro que existan en el repositorio
     * @return
     */
    List<Libro> listarLibros();

    /**
     * Función en la capa service que se encarga de la comunicación con
     * la capa de persitencia para cumplir con la tarea de recuperar 
     * un libro por su Id
     * @param id
     * @return
     */
    Libro libroPorId(Long id);

    /**
     * Función en la capa service que se encarga de la comunicación con
     * la capa de persitencia para cumplir con la tarea de actualizar
     * un libro por su Id de la colección que existe en la persistencia 
     * @param id
     * @param libro
     * @return
     */
    Libro actualizarLibro(Long id, Libro libro);

    /**
     * Función en la capa service que se encarga de la comunicación con
     * la capa de persitencia para cumplir con la tarea de eliminar
     * un libro por su Id de la colección que existe en la persistencia
     * @param id
     */
    void eliminarLibro(Long id);

    /**
     * Función en la capa service que se encarga de la comunicación con
     * la capa de persitencia para cumplir con la tarea de buscar coincidencias 
     * dentro de los títulos de los libros 
     * @param texto
     * @return
     */
    List<Libro> librosConCoincidencia(String texto);
}
