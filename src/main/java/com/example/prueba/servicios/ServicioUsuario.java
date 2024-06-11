package com.example.prueba.servicios;

import com.example.prueba.entidades.Usuario;
import com.example.prueba.repositorios.UsuarioRepositorio;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicioUsuario {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    Usuario usuario;

   public List<Usuario> buscaTodo() throws Exception {

        try {
            //validaciones
            return this.usuarioRepositorio.findAll();
       } catch (Exception error) {
            throw new Exception("parce no dio");
       }
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

    public Usuario updateUser(@NotNull Usuario usuario) {
        Usuario usuarioExistente = usuarioRepositorio.findById(usuario.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("No se encontro el id: " + usuario.getIdUsuario()));

        if (usuario.getNombre() != null) {
            usuarioExistente.setNombre(usuario.getNombre());
        }
        if (usuario.getApellido() != null) {
            usuarioExistente.setApellido(usuario.getApellido());
        }
        if (usuario.getCedula() != null) {
            usuarioExistente.setCedula(usuario.getCedula());
        }
        if (usuario.getContrasena() != null) {
            usuarioExistente.setContrasena(usuario.getContrasena());
        }
        if (usuario.getFechaNacimiento() != null) {
            usuarioExistente.setFechaNacimiento(usuario.getFechaNacimiento());
        }
        if (usuario.getDireccion() != null) {
            usuarioExistente.setDireccion(usuario.getDireccion());
        }
        if (usuario.getCorreo() != null) {
            usuarioExistente.setCorreo(usuario.getCorreo());
        }
        if (usuario.getTelefono() != null) {
            usuarioExistente.setTelefono(usuario.getTelefono());
        }

        return usuarioRepositorio.save(usuarioExistente);
    }


    public List<Usuario> searchUsuarios(String nombre, String apellido) {
        return usuarioRepositorio.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(nombre, apellido);
    }



}


