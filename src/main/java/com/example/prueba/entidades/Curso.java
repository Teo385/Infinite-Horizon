package com.example.prueba.entidades;


import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "CURSOS")
public class Curso {

    @Id
    @Column(name = "ID_CURSO")
    private Number idCurso;

    @Column(name = "NOMBRE_CURSO")
    private String nombreCurso;

    @Column(name = "FK_ID_PROFESOR")
    private Number fkIdProfesor;

    @Column(name = "DEPARTAMENTO")
    private String departamento;

    @Column(name = "HORARIO")
    private String horario;

    @Column(name = "CREDITOS")
    private Number creditos;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROFESOR", insertable = false, updatable = false)
    private Profesor profesor;

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Number getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Number idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Number getFkIdProfesor() {
        return fkIdProfesor;
    }

    public void setFkIdProfesor(Number fkIdProfesor) {
        this.fkIdProfesor = fkIdProfesor;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Number getCreditos() {
        return creditos;
    }

    public void setCreditos(Number creditos) {
        this.creditos = creditos;
    }
}
