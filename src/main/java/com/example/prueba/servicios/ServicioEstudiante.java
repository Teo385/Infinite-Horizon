package com.example.prueba.servicios;

import com.example.prueba.entidades.Estudiante;
import com.example.prueba.repositorios.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> getEstudianteById(Integer id) {
        return estudianteRepository.findById(id);
    }

    public List<Estudiante> getEstudiantesByAnioIngreso(Integer anioIngreso) {
        return estudianteRepository.findByAnioIngreso(anioIngreso);
    }

    public List<Estudiante> getEstudiantesByCarrera(String carrera) {
        return estudianteRepository.findByCarrera(carrera);
    }

    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public void deleteEstudiante(Integer id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
        }
    }
}
