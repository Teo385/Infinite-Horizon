package com.example.prueba.repositorios;

import com.example.prueba.entidades.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository  extends JpaRepository<Estudiante,Integer> {

    List<Estudiante> findByAnioIngreso(Integer anioIngreso);


    List<Estudiante> findByCarrera(String carrera);

}