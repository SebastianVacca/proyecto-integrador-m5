package com.devsenior.svacca.proyecto_integrador_m5.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.svacca.proyecto_integrador_m5.model.Libro;
import com.devsenior.svacca.proyecto_integrador_m5.service.interfaces.LibroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Préstamo de libros", description = "API para un Sistema simplificado de gestión de Biblioteca")
@RestController
@RequestMapping("/api/libros")
public class LibrosController {

    private LibroService libroService;

    public LibrosController(LibroService libroService) {
        this.libroService = libroService;
    }

    @Operation(summary = "Retorno de lista de libros", description = "Este servicio permite retornar la lista dompleta de los libros existentes en la memoria temporal")
    @ApiResponse(responseCode = "200", description = "Transacción exitosa")
    @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Libro> busquedaCompleta() {
        return libroService.listarLibros();
    }

    @Operation(summary = "Búsqueda de libro por Id", description = "Este servicio permite realizar un busqueda por Id dentro de la lista de libros que existan en la memoria temporal")
    @ApiResponse(responseCode = "500", description = "Libro no existe, libro no encontrado", content = @Content())
    @ApiResponse(responseCode = "200", description = "Transacción exitosa")
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Libro buscaLibroId(@RequestParam Long id) {
        return libroService.libroPorId(id);
    }

    @Operation(summary = "Búsqueda de coincidencia de texto en el título", description = "Este servicio permite realizar un búsqueda de coincidencias en el título de la lista de libros que existan en la memoria temporal")
    @ApiResponse(responseCode = "200", description = "Transacción exitosa")
    @GetMapping(value = "/buscar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Libro> buscarLibroCoincidencia(@RequestParam(value = "texto") String texto) {
        return libroService.librosConCoincidencia(texto);
    }

    @Operation(summary = "Crear un libro", description = "Este servicio permite crear un libro y agregarlo a la lista de libros en la memoria temporal")
    @ApiResponse(responseCode = "200", description = "Transacción exitosa")
    @ApiResponse(responseCode = "400", description = "Transacción fallida, revise que todos los campos estén completos")
    @ApiResponse(responseCode = "500", description = "Transacción fallida, falla en la comunicación con el servidor")
    @PostMapping("")
    public Libro crearLibro(
            @RequestBody(description = "Información del libro a crear", required = true, content = @Content(schema = @Schema(implementation = Libro.class))) @org.springframework.web.bind.annotation.RequestBody @Valid Libro libro) {
        libro = libroService.crearLibro(libro);
        return libro;
    }

    @Operation(summary = "Actualizar un libro", description = "Este servicio permite actualizar un libro existente en la lista de libros en la memoria temporal")
    @ApiResponse(responseCode = "500", description = "Este libro no se puede actualizar, libro no encontrado o libro no existe", content = @Content())
    @ApiResponse(responseCode = "200", description = "Transacción exitosa")
    @PutMapping("/{id}")
    public Libro actualizarLibro(
            @PathVariable Long id,
            @RequestBody(description = "Información del libro a actualizar", required = true, content = @Content(schema = @Schema(implementation = Libro.class))) @org.springframework.web.bind.annotation.RequestBody @Valid Libro libro) {
        return libroService.actualizarLibro(id, libro);
    }

    @Operation(summary = "Eliminar un libro", description = "Este servicio permite eliminar un libro de la lista de libros en la memoria temporal")
    @ApiResponse(responseCode = "500", description = "Este libro no se puede actualizar, libro no encontrado o libro no existe", content = @Content())
    @ApiResponse(responseCode = "200", description = "Transacción exitosa")
    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
}
