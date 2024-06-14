package com.example.prueba.controller;

import com.example.prueba.entidades.Usuario;
import com.example.prueba.servicios.ServicioUsuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    ServicioUsuario servicioUsuario;

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Obtener todos los usuarios", description = "Retorna una lista de todos los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud",
                    content = @Content)
    })
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

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Obtener usuario por ID", description = "Retorna un usuario que coincide con el ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud",
                    content = @Content)
    })

    @GetMapping("/id/{idUsuario}")
    public ResponseEntity<?> getUsuario(
            @Parameter(description = "ID del usuario", required = true)
            @PathVariable("idUsuario") Integer idUsuario) {
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

    @Operation(summary = "Obtener usuarios por género", description = "Retorna una lista de usuarios que coinciden con el género proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud",
                    content = @Content)
    })
    @GetMapping("/genero/{genero}")
    public ResponseEntity<?> getByGenero(
            @Parameter(description = "Género del usuario", required = true)
            @PathVariable("genero") String genero) {
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

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Guardar un nuevo usuario", description = "Guarda un nuevo usuario en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario guardado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud",
                    content = @Content)
    })
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

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Eliminar usuario por ID", description = "Elimina un usuario de la base de datos por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    })
    @DeleteMapping("/delete/{idUsuario}")
    public ResponseEntity<?> delete(
            @Parameter(description = "ID del usuario", required = true)
            @PathVariable("idUsuario") Integer idUsuario) {
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
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update/{idUsuario}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario usuario) {
        try {
            Usuario usuarioActualizado = servicioUsuario.updateUser(usuario);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioActualizado);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

 //   @GetMapping("/buscar/{nombre}/{apellido}")
 //   public ResponseEntity<?> searchUsuarios(@PathVariable(required = false) String nombre, @PathVariable(required = false) String apellido) {
 //       try {
 //           List<Usuario> usuarios = servicioUsuario.searchUsuarios(nombre, apellido);
 //           return ResponseEntity
 //                   .status(HttpStatus.OK)
 //                   .body(usuarios);
 //       } catch (Exception error) {
 //           return ResponseEntity
 //                   .status(HttpStatus.BAD_REQUEST)
 //                   .body(error.getMessage());
 //       }
 //   }

   // @GetMapping("/buscar/{nombreCompleto}")
   // public List<Usuario> buscarPersona(@PathVariable String nombreCompleto) {
   //     return servicioUsuario.buscarPersona(nombreCompleto);
   // }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/buscar/{nombreCompleto}")
    public List<Usuario> buscarPersona(@PathVariable String nombreCompleto) {
        String[] partes = nombreCompleto.split(" ");
        if (partes.length > 1) {
            // Buscar por nombre y apellido
            return servicioUsuario.buscarPersona(partes[0], partes[1]);
        } else {
            // Buscar por nombre
            return servicioUsuario.buscarPersona(partes[0], null);
        }
    }

}
