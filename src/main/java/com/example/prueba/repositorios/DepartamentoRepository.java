package com.example.prueba.repositorios;

import com.example.prueba.entidades.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Number> {
}
