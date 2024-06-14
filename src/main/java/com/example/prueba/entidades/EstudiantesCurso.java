package com.example.prueba.entidades;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "ESTUDIANTES_CURSOS")
public class EstudiantesCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTUDIANTE_CURSO")
    private Long idEstudianteCurso;

    @Column(name = "FK_ID_ESTUDIANTE")
    private Number fkIdEstudiante;

    @Column(name = "FK_ID_CURSO")
    private Number fkIdCurso;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ESTUDIANTE", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "FK_ID_CURSO", insertable = false, updatable = false)
    private Curso curso;

    @OneToMany(mappedBy = "estudianteCurso")
    private List<Calificacion> estudianteCurso;

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
        return estudianteCurso;
    }

    public void setEstudianteCurso(List<Calificacion> estudianteCurso) {
        this.estudianteCurso = estudianteCurso;
    }

    public Long getIdEstudianteCurso() {
        return idEstudianteCurso;
    }

    public void setIdEstudianteCurso(Long idEstudianteCurso) {
        this.idEstudianteCurso = idEstudianteCurso;
    }

    public Number getFkIdEstudiante() {
        return fkIdEstudiante;
    }

    public void setFkIdEstudiante(Number fkIdEstudiante) {
        this.fkIdEstudiante = fkIdEstudiante;
    }

    public Number getFkIdCurso() {
        return fkIdCurso;
    }

    public void setFkIdCurso(Number fkIdCurso) {
        this.fkIdCurso = fkIdCurso;
    }
}