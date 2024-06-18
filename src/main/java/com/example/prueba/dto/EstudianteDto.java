package com.example.prueba.dto;

import java.util.List;

public class EstudianteDto {

    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String carrera;
    private String nombresCursos;
    private String nombreProfesor;
    private String apellidoProfesor;
    private Integer numeroAula;
    private String pisoAula;
    private String edificioAula;
    private Number fkIdUsuario  ;


    public Number getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Number fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNombresCursos() {
        return nombresCursos;
    }

    public void setNombresCursos(List<String> nombresCursos) {
        this.nombresCursos = String.join(", ", nombresCursos);
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
    }

    public Integer getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(Integer numeroAula) {
        this.numeroAula = numeroAula;
    }

    public void setNombresCursos(String nombresCursos) {
        this.nombresCursos = nombresCursos;
    }

    public String getPisoAula() {
        return pisoAula;
    }

    public void setPisoAula(String pisoAula) {
        this.pisoAula = pisoAula;
    }

    public String getEdificioAula() {
        return edificioAula;
    }

    public void setEdificioAula(String edificioAula) {
        this.edificioAula = edificioAula;
    }
}