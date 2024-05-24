package com.example.prueba.servicios;

import com.example.prueba.entidades.Empleado;
import com.example.prueba.repositorios.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpleado {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(Integer idEmpleado) {
        return empleadoRepository.findById(idEmpleado).orElse(null);
    }

    public List<Empleado> getEmpleadoByArea(String area) {
        return empleadoRepository.findByArea(area);
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}


