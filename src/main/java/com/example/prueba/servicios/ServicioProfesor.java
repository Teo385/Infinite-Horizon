
package com.example.prueba.servicios;

import com.example.prueba.entidades.Profesor;
import com.example.prueba.repositorios.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProfesor {
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> getAllProfesores() {
        return profesorRepository.findAll();
    }

    public Profesor getProfesorById(Integer id) {
        return profesorRepository.findById(id).orElse(null);
    }

    public List<Profesor> getProfesorByDepartamento(String departamento) {
        return profesorRepository.findByDepartamento(departamento);
    }

    public Profesor saveProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }
}
