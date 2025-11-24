package com.devsenior.svacca.proyecto_integrador_m5.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.devsenior.svacca.proyecto_integrador_m5.exception.LibroNoEncontradoException;
import com.devsenior.svacca.proyecto_integrador_m5.model.Libro;

@Repository
public class LibrosRepository {

    private List<Libro> libros;
    private AtomicLong consecutivo;

    public LibrosRepository(List<Libro> libros) {
        this.libros = new ArrayList<>();
        consecutivo = new AtomicLong(1);
    }

    /**
     * Función en la capa de persistencia que permite crear un libro, el id es autoincremental
     * @param libro
     */
    public void save(Libro libro) {
        libro.setId(consecutivo.getAndIncrement());
        libros.add(libro);
    }

    /**
     * Función en la capa de persistencia que permite actaulizar los campos de un libro
     * @param id
     * @param libro
     * @return
     */
    public Libro update(Long id, Libro libro){
        var libroActualizar = findById(id);

        libroActualizar.setTitulo(libro.getTitulo());
        libroActualizar.setAutor(libro.getAutor());
        libroActualizar.setIsbn(libro.getIsbn());
        libroActualizar.setGenero(libro.getGenero());
        libroActualizar.setAnioPublicacion(libro.getAnioPublicacion());

        return libroActualizar;
    }

    /**
     * Función en la capa de persistencia que permite buscar un libro por medio del Id
     * @param id
     * @return
     */
    public Libro findById(Long id) {
        var libro = libros.stream().filter(l -> l.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new LibroNoEncontradoException(
                        String.format("EL Id %d no corresponde a ningún libro", id)));

        return libro;
    }
    
    /**
     * Función en la capa de persistencia que trae una copia de todos  los libros que existan en la memoria temporal
     * @return
     */
    public List<Libro> findAll(){
        return new ArrayList<Libro>(libros);
    }

    /**
     * Función en la capa de persistencia que busca un libro por medio del Id y lo elimina
     * @param id
     * @return
     */
    public String deleteById(Long id){
        var libro = findById(id);
        libros.remove(libro);

        return String.format("El libro con el Id %d fue eliminado", id);
    }

    public List<Libro> findContains(String texto){
        return libros.stream().filter(l -> l.getTitulo().toLowerCase().contains(texto.toLowerCase())).toList();
    }
}
