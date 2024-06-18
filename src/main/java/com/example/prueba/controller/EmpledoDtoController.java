package com.example.prueba.controller;

import com.example.prueba.dto.EmpleadosDto;
import com.example.prueba.servicios.ServicioEmpleadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleadoDto")
public class EmpledoDtoController {


    @Autowired
    private ServicioEmpleadoDto servicioEmpleadoDto;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadosDto> infoEmpleado(@PathVariable Integer id) {
        EmpleadosDto dto = servicioEmpleadoDto.empleadoDto(id);

        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<EmpleadosDto>> infoEmpleados() {
        List<EmpleadosDto> dtos = servicioEmpleadoDto.empleadosDtos();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
