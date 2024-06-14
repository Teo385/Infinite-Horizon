package com.example.prueba.entidades;


import jakarta.persistence.*;


@Entity
@Table(name = "CALIFICACIONES")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_CALIFICACION")
    private Number idCalificacion;

    @Column(name = "FK_ID_ESTUDIANTE_CURSO")
    private Number fkIdEstudianteCurso;

    @Column(name = "CALIFICACION")
    private Number calificacion;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ESTUDIANTE_CURSO", insertable = false, updatable = false)
    private EstudiantesCurso estudianteCurso;

    public EstudiantesCurso getEstudianteCurso() {
        return estudianteCurso;
    }

    public void setEstudianteCurso(EstudiantesCurso estudianteCurso) {
        this.estudianteCurso = estudianteCurso;
    }

    public Number getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Number idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Number getFkIdEstudianteCurso() {
        return fkIdEstudianteCurso;
    }

    public void setFkIdEstudianteCurso(Number fkIdEstudianteCurso) {
        this.fkIdEstudianteCurso = fkIdEstudianteCurso;
    }

    public Number getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Number calificacion) {
        this.calificacion = calificacion;
    }
}
