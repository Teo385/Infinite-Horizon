package com.example.prueba.controller;

import com.example.prueba.entidades.Empleado;
import com.example.prueba.servicios.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private ServicioEmpleado servicioEmpleado;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = servicioEmpleado.getAllEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/id/{idEmpleado}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Integer idEmpleado) {
        Empleado empleado = servicioEmpleado.getEmpleadoById(idEmpleado);
        if (empleado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @GetMapping("/area/{area}")
    public ResponseEntity<List<Empleado>> getEmpleadoByArea(@PathVariable String area) {
        List<Empleado> empleados = servicioEmpleado.getEmpleadoByArea(area);
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = servicioEmpleado.saveEmpleado(empleado);
        return new ResponseEntity<>(savedEmpleado, HttpStatus.CREATED);
    }
}



