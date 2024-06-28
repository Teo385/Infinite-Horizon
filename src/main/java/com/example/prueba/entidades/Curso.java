package com.example.prueba.entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "CURSOS")
public class Curso {

    @Id
    @Column(name = "ID_CURSO")
    private Integer idCurso;

    @Column(name = "NOMBRE_CURSO")
    private String nombreCurso;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROFESOR", insertable = false, updatable = false)
    @JsonIgnore
    private Profesor profesor;

    @Column(name = "FK_ID_PROFESOR")
    private Integer fkIdProfesor;

    @Column(name = "DEPARTAMENTO")
    private String departamento;

    @Column(name = "HORARIO")
    private String horario;

    @Column(name = "CREDITOS")
    private Integer creditos;

    @OneToMany(mappedBy = "curso")
    @JsonIgnore
    private List<EstudiantesCurso> estudiantesCurso;

    public Profesor getProfesor() {
        return profesor;
    }

    public List<EstudiantesCurso> getEstudiantesCurso() {
        return estudiantesCurso;
    }

    public void setEstudiantesCurso(List<EstudiantesCurso> estudiantesCurso) {
        this.estudiantesCurso = estudiantesCurso;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getFkIdProfesor() {
        return fkIdProfesor;
    }

    public void setFkIdProfesor(Integer fkIdProfesor) {
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

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
}
