package com.example.prueba.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Entity
@Table(name = "ESTUDIANTES")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTUDIANTE")
    private Integer idEstudiante;

    @Column(name = "FK_ID_USUARIO")
    private Integer fkIdUsuario;

    @OneToOne
    @JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "ID_USUARIO",insertable = false, updatable = false)
    @JsonBackReference
    private Usuario usuario;

    @Column(name = "CARRERA")
    private String carrera;

    @Column(name = "AÑO_INGRESO")
    private Integer anioIngreso;

    @Column(name = "ESTADO")
    private String estado;



//    @OneToMany(mappedBy = "estudiante")
//    List<EstudiantesCurso> estudiante;
//
//    public List<EstudiantesCurso> getEstudiante() {
//        return estudiante;
//    }
//
//    public void setEstudiante(List<EstudiantesCurso> estudiante) {
//        this.estudiante = estudiante;
//    }


    public Integer getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Integer fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }


    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(Integer anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
