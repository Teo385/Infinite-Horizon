package com.example.prueba.servicos;

import com.example.prueba.entidades.Usuario;
import com.example.prueba.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuario {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

//    public List<Usuario> buscaTodo() throws Exception {
//
//        try {
//            //validaciones
//            return (List<Usuario>) this.usuarioRepositorio.findAll();
//        } catch (Exception error) {
//            throw new Exception("parce no dio");
//        }
//    }
    public List<Usuario> buscaTodo()  {
        return (List<Usuario>) this.usuarioRepositorio.findAll();
    }

    public Usuario getUser(Integer id){
        return usuarioRepositorio.getReferenceById(id);
    }

    public List<Usuario> getByGenero(String genero){
        return usuarioRepositorio.findByGeneroOrderByNombreAsc(genero);
    }

    public List<Usuario> getByTipo(Number tipo){
        return usuarioRepositorio.findByTipo(tipo);
    }

    public Usuario save(Usuario user){
        return usuarioRepositorio.save(user);
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


