package com.example.prueba.dto;

public class ProfesorDto {
    private Integer idUsuario;
    private String nombreProfesor;
    private String apellidoProfesor;
    private String nombreDepartamento;
    private String jefeDepartamento;
    private Integer numeroAula;
    private String edificioAula;
    private String nombreCurso;
    private String horaCurso;
    private String especializacionProfesor;


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(String jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;
    }

    public Integer getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(Integer numeroAula) {
        this.numeroAula = numeroAula;
    }

    public String getEdificioAula() {
        return edificioAula;
    }

    public void setEdificioAula(String edificioAula) {
        this.edificioAula = edificioAula;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getHoraCurso() {
        return horaCurso;
    }

    public void setHoraCurso(String horaCurso) {
        this.horaCurso = horaCurso;
    }

    public String getEspecializacionProfesor() {
        return especializacionProfesor;
    }

    public void setEspecializacionProfesor(String especializacionProfesor) {
        this.especializacionProfesor = especializacionProfesor;
    }
}
