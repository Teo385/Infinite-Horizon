package com.example.prueba.controller;

import com.example.prueba.dto.EstudianteDto;
import com.example.prueba.servicios.ServicioEstudianteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudianteDto")
public class EstudianteDtoController {

    @Autowired
    private ServicioEstudianteDto servicioEstudianteDto;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> obtenerInformacionEstudiante(@PathVariable Integer id) {
        EstudianteDto dto = servicioEstudianteDto.obtenerInformacionEstudiante(id);

        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<EstudianteDto>> obtenerInformacionTodosEstudiantes() {
        List<EstudianteDto> dtos = servicioEstudianteDto.obtenerInformacionTodosEstudiantes();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/curso/{nombreCurso}")
    public List<EstudianteDto> obtenerEstudiantesPorCurso(@PathVariable String nombreCurso) {
        return servicioEstudianteDto.obtenerEstudiantesPorCurso(nombreCurso);
    }

}
