package com.example.prueba.repositorios;

import com.example.prueba.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository  extends JpaRepository<Empleado, Integer> {

    List<Empleado> findByArea(String area);
}
