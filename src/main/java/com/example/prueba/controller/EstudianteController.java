package com.example.prueba.controller;

import com.example.prueba.entidades.Estudiante;
import com.example.prueba.servicios.ServicioEstudiante;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.prueba.repositorios.EstudianteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private ServicioEstudiante servicioEstudiante;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("/all")
    public List<Estudiante> getAllEstudiantes() {
        return servicioEstudiante.getAllEstudiantes();
    }

    @GetMapping("/id/{idEstudiante}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Integer idEstudiante) {
        Optional<Estudiante> estudiante = servicioEstudiante.getEstudianteById(idEstudiante);
        return estudiante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/anioIngreso/{anioIngreso}")
    public List<Estudiante> getEstudiantesByAnioIngreso(@PathVariable Integer anioIngreso) {
        return servicioEstudiante.getEstudiantesByAnioIngreso(anioIngreso);
    }

    @GetMapping("/carrera/{carrera}")
    public List<Estudiante> getEstudiantesByCarrera(@PathVariable String carrera) {
        return servicioEstudiante.getEstudiantesByCarrera(carrera);
    }

    @PostMapping("/save")
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
        return servicioEstudiante.createEstudiante(estudiante);
    }

    @DeleteMapping("/delete/{idEstudiante}")
    public ResponseEntity<?> delete(@PathVariable("idEstudiante") Integer idEstudiante) {
        try {
            boolean deleted = servicioEstudiante.delete(idEstudiante);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(deleted);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
