package com.example.prueba.controller;

import com.example.prueba.entidades.Profesor;
import com.example.prueba.servicios.ServicioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    private ServicioProfesor servicioProfesor;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Profesor>> getAllProfesores() {
        List<Profesor> profesores = servicioProfesor.getAllProfesores();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/id/{idProfesor}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Integer idProfesor) {
        Profesor profesor = servicioProfesor.getProfesorById(idProfesor);
        if (profesor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(profesor, HttpStatus.OK);
    }

    @GetMapping("/departamento/{departamento}")
    public ResponseEntity<List<Profesor>> getProfesorByDepartamento(@PathVariable String departamento) {
        List<Profesor> profesores = servicioProfesor.getProfesorByDepartamento(departamento);
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Profesor> saveProfesor(@RequestBody Profesor profesor) {
        Profesor savedProfesor = servicioProfesor.saveProfesor(profesor);
        return new ResponseEntity<>(savedProfesor, HttpStatus.CREATED);
    }
}
