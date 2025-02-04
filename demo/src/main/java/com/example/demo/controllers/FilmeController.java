package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import com.example.demo.models.Filme;
import com.example.demo.services.FilmeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/filme")
@Tag(name = "Filmes", description = "Endpoints para gerenciamento de filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @Operation(summary = "Lista todos os filmes")
    @GetMapping
    public ResponseEntity<Iterable<Filme>> getAllFilmes() {
        Iterable<Filme> filmes = this.filmeService.findAll();
        return ResponseEntity.ok().body(filmes);
    }

    @Operation(summary = "Cria um novo filme")
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Filme filme){
         this.filmeService.save(filme);
System.out.println("E filme?" +filme.isEFilme());

         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(filme.getId()).toUri() ;
         return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Deleta um filme pelo código")
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteByCodigo(@PathVariable int codigo){
        this.filmeService.deleteByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca um filme pelo código")
    @GetMapping("/{codigo}")
    public Filme getFilmeByCodigo(@PathVariable int codigo){
        return filmeService.findByCodigo(codigo).orElse(new Filme());
    }
}