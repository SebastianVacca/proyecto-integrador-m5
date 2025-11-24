package com.devsenior.svacca.proyecto_integrador_m5.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.svacca.proyecto_integrador_m5.model.Libro;
import com.devsenior.svacca.proyecto_integrador_m5.service.interfaces.LibroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/libros")
public class LibrosController {

    private LibroService libroService;

    public LibrosController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("")
    public List<Libro> busquedaCompleta() {
        return libroService.listarLibros();
    }   

    @GetMapping("/{id}")
    public Libro buscaLibroId(@RequestParam Long id) {
        return libroService.libroPorId(id);
    }

    @GetMapping("/buscar")
    public List<Libro> buscarLibroCoincidencia(@RequestParam(value = "texto") String texto) {
        return libroService.librosConCoincidencia(texto);
    }

    @PostMapping("")
    public Libro crearLibro(@RequestBody Libro libro) {       
        libro = libroService.crearLibro(libro);
        return libro;
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {      
        return libroService.actualizarLibro(id, libro);
    }
    
    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id){
        libroService.eliminarLibro(id);
    }  
}
