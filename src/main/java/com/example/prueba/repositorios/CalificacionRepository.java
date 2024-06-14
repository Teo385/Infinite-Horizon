package com.example.prueba.repositorios;

import com.example.prueba.entidades.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepository  extends JpaRepository<Calificacion, Number> {
}