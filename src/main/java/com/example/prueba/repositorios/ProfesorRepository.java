package com.example.prueba.repositorios;

import com.example.prueba.entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    List<Profesor> findByDepartamento(String departamento);
}
