package com.example.prueba.repositorios;

import com.example.prueba.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository  extends JpaRepository<Curso, Number> {
}
