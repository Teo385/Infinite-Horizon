package com.example.prueba.servicios;

import com.example.prueba.entidades.Usuario;
import com.example.prueba.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuario {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

   public List<Usuario> buscaTodo() throws Exception {

        try {
            //validaciones
            return this.usuarioRepositorio.findAll();
       } catch (Exception error) {
            throw new Exception("parce no dio");
       }
    }

    public List<Usuario> findAllDistinct() {
        return usuarioRepositorio.findAllDistinct();
    }

    public Usuario getUsuario(Integer id){
        return usuarioRepositorio.getReferenceById(id);
    }

    public List<Usuario> getByGenero(String genero){
        return usuarioRepositorio.findByGeneroOrderByNombreAsc(genero);
    }


    public Usuario save(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public boolean delete(Integer id) {
        return usuarioRepositorio.findById(id)
                .map(usuario -> {
                    usuarioRepositorio.delete(usuario);
                    return true;
                })
                .orElse(false);
    }

}


