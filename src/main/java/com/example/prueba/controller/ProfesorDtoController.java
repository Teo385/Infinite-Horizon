package com.example.prueba.controller;

import com.example.prueba.dto.ProfesorDto;
import com.example.prueba.servicios.ServicioProfesorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesorDto")
public class ProfesorDtoController {


    @Autowired
    private ServicioProfesorDto servicioProfesorDto;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDto> infoProfe(@PathVariable Integer id) {
        ProfesorDto dto = servicioProfesorDto.profesorDto(id);

        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<ProfesorDto>> infoProfes() {
        List<ProfesorDto> dtos = servicioProfesorDto.profesoresDto();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
