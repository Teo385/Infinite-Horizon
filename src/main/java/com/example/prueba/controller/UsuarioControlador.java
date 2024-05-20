package com.example.prueba.controller;

import com.example.prueba.servicos.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioControlador {
    @Autowired
    ServicioUsuario servicioUsuario;

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {

            return ResponseEntity.
                    status(HttpStatus.OK).
                    body(this.servicioUsuario.buscaTodo());

        } catch (Exception error) {
            return ResponseEntity.
                    status(HttpStatus.BAD_REQUEST).
                    body(error.getMessage());
        }

    }

}
