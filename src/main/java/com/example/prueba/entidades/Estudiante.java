package com.University.of.the.infinite.Horizon.persistence.entity;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Entity
@Table(name = "ESTUDIANTES")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTUDIANTE")
    private Number idEstudiante;

    @Column(name = "FK_ID_USUARIO")
    private Number fkIdUsuario;

    @Column(name = "CARRERA")
    private String carrera;

    @Column(name = "AÑO_INGRESO")
    private Number anioIngreso;

    @Column(name = "ESTADO")
    private String estado;
    //Tal vez ignorar en el mapper
    @OneToOne
    @JoinColumn(name = "FK_ID_Usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "estudiante")
    List<EstudiantesCurso> estudiante;

    public List<EstudiantesCurso> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(List<EstudiantesCurso> estudiante) {
        this.estudiante = estudiante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Number getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Number idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Number getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Number fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Number getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(Number anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
