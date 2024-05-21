package com.example.prueba.controller;

import com.example.prueba.entidades.Usuario;
import com.example.prueba.servicos.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    ServicioUsuario servicioUsuario;

    @GetMapping("/all")
    public ResponseEntity<?> buscaTodo() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioUsuario.buscaTodo());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/id/{idUsuario}")
    public ResponseEntity<?> getUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        try {
            Usuario usuario = servicioUsuario.getUsuario(idUsuario);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuario);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<?> getByGenero(@PathVariable("genero") String genero) {
        try {
            String generoMayuscula = genero.toUpperCase(Locale.getDefault());
            List<Usuario> usuarios = servicioUsuario.getByGenero(generoMayuscula);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarios);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Usuario usuario) {
        try {
            Usuario savedUsuario = servicioUsuario.save(usuario);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(savedUsuario);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/delete/{idUsuario}")
    public ResponseEntity<?> delete(@PathVariable("idUsuario") Integer idUsuario) {
        try {
            boolean deleted = servicioUsuario.delete(idUsuario);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(deleted);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
