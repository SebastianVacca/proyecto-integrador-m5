package com.devsenior.svacca.proyecto_integrador_m5.model;

import java.sql.Date;

public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Date anioPublicacion;
    private String opcional;
    private Estado estado;

    
    public Libro() {
    }  

    public Libro(Long id, String titulo, String autor, String isbn, Date anioPublicacion, String opcional,
            Estado estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.opcional = opcional;
        this.estado = estado;
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


    public String getOpcional() {
        return opcional;
    }


    public void setOpcional(String opcional) {
        this.opcional = opcional;
    }


    public Estado getEstado() {
        return estado;
    }


    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    

    
}
