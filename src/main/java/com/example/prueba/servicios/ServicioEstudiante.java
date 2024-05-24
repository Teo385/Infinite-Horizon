package com.example.prueba.servicios;

import com.example.prueba.entidades.Estudiante;
import com.example.prueba.repositorios.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEstudiante {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> getEstudianteById(Integer idEstudiante) {
        return estudianteRepository.findById(idEstudiante);
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


    public boolean delete(Integer id) {
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    estudianteRepository.delete(estudiante);
                    return true;
                })
                .orElse(false);
    }
}
