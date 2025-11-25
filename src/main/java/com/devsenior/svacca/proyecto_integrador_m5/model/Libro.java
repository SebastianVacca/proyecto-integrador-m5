package com.devsenior.svacca.proyecto_integrador_m5.model;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Representa un Libro")
public class Libro {

    
    private Long id;

    @Schema(description = "Título del libro", example = "El libro de Juan")
    @NotBlank(message = "El campo Título del libro es obligatorio")
    private String titulo;

    @Schema(description = "Autor o Autores del libro", example = "Juan Perez, Benito Juarez")    
    private String autor;

    @Schema(description = "Código ISBN del libro debe ser único", example = "978-84-9989-172-4")
    @NotBlank(message = "El campo Título del libro es obligatorio")
    private String isbn;

    @Schema(description = "Fecha de publicación del libro", example = "1999-01-01")
    private Date anioPublicacion;

    @Schema(description = "Genero literario al que pertenece el libro", example = "Comedia")
    private String genero;

    @Schema(description = "Estado del libro en estanteria el libro", example = "Disponible")    
    private Estado estado;

    
    public Libro() {
    }  

    public Libro(Long id, String titulo, String autor, String isbn, Date anioPublicacion, String genero,
            Estado estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.estado = Estado.DISPONIBLE;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Date getAnioPublicacion() {
        return anioPublicacion;
    }


    public void setAnioPublicacion(Date anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String opcional) {
        this.genero = opcional;
    }


    public Estado getEstado() {
        return estado;
    }


    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    

    
}
