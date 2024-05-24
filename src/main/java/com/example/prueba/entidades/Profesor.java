package com.University.of.the.infinite.Horizon.persistence.entity;

import jakarta.persistence.*;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PROFESORES")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROFESOR")
    private Number idProfesor;

    @Column(name = "FK_ID_USUARIO")
    private Number fkIdUsuario;

    @Column(name = "DEPARTAMENTO")
    private String departamento;

    @Column(name = "FECHA_CONTRATACION")
    private LocalDateTime fechaContratacion;

    @Column(name = "ESPECIALIZACION")
    private String especializacion;

    @OneToOne
    @JoinColumn(name = "FK_ID_Usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "profesor")
    private List<ProfesoresAula> profesor;

    @OneToMany(mappedBy = "profesor")
    private List<Curso>  cursos;

    @OneToMany(mappedBy = "jefeDepartamentoProfesor")
    private List<Departamento>  departamentos;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ProfesoresAula> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<ProfesoresAula> profesor) {
        this.profesor = profesor;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public Number getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Number idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Number getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Number fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public LocalDateTime getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDateTime fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }
}
