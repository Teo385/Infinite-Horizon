package com.example.prueba.repositorios;

import com.example.prueba.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio  extends JpaRepository<Usuario,Integer> {
    List<Usuario> findByGeneroOrderByNombreAsc(String genero);
    @Query("SELECT DISTINCT u FROM Usuario u")
    List<Usuario> findAllDistinct();

    Usuario getReferenceById(Integer id);

    List<Usuario> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);
}



