package com.example.prueba.repositorios;

import com.example.prueba.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio  extends CrudRepository<Usuario,Integer> {
    List<Usuario> findByGeneroOrderByNombreAsc(String genero);
    List<Usuario> findByTipo(Number tipo);


    Usuario getReferenceById(Integer id);
}



