package com.example.prueba.controller;


import com.example.prueba.entidades.Aula;
import com.example.prueba.servicios.ServicioAula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    ServicioAula servicioAula;

    @GetMapping("/all")
    public List<Aula> getAllAulas() {
        return servicioAula.getAllAulas();
    }

    @GetMapping("/{id}")
    public Aula getAulaById(@PathVariable Integer id) {
        return servicioAula.getAulaById(id);
    }

    @PostMapping
    public Aula createAula(@RequestBody Aula aula) {
        return servicioAula.createAula(aula);
    }

    @PutMapping("/{id}")
    public Aula updateAula(@PathVariable Integer id, @RequestBody Aula aula) {
        aula.setIdAula(id);
        return servicioAula.updateAula(aula);
    }

    @DeleteMapping("/{id}")
    public void deleteAulaById(@PathVariable Integer id) {
        servicioAula.deleteAulaById(id);
    }
}