package com.example.prueba.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "ESTUDIANTES_CURSOS")
public class EstudiantesCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTUDIANTE_CURSO")
    private Integer idEstudianteCurso;

    @Column(name = "FK_ID_ESTUDIANTE")
    private Integer fkIdEstudiante;

    @Column(name = "FK_ID_CURSO")
    private Integer fkIdCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_ESTUDIANTE", referencedColumnName = "ID_ESTUDIANTE", insertable = false, updatable = false)
    @JsonIgnore
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "FK_ID_CURSO", referencedColumnName = "ID_CURSO", insertable = false, updatable = false)
    @JsonIgnore
    private Curso curso;

    @OneToMany(mappedBy = "estudianteCurso")
    @JsonIgnore
    private List<Calificacion> calificacion;

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Calificacion> getEstudianteCurso() {
        return calificacion;
    }

    public void setEstudianteCurso(List<Calificacion> calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getIdEstudianteCurso() {
        return idEstudianteCurso;
    }

    public void setIdEstudianteCurso(Integer idEstudianteCurso) {
        this.idEstudianteCurso = idEstudianteCurso;
    }

    public Integer getFkIdEstudiante() {
        return fkIdEstudiante;
    }

    public void setFkIdEstudiante(Integer fkIdEstudiante) {
        this.fkIdEstudiante = fkIdEstudiante;
    }

    public Integer getFkIdCurso() {
        return fkIdCurso;
    }

    public void setFkIdCurso(Integer fkIdCurso) {
        this.fkIdCurso = fkIdCurso;
    }
}