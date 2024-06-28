package com.example.prueba.repositorios;

import com.example.prueba.entidades.Curso;
import com.example.prueba.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepository  extends JpaRepository<Curso, Integer> {

    @Query("SELECT e FROM Estudiante e JOIN e.estudiantesCurso ec JOIN ec.curso c WHERE c.nombreCurso = :nombreCurso")
    List<Estudiante> findEstudiantesPorCurso(@Param("nombreCurso") String nombreCurso);

}