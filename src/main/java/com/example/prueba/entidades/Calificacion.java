package com.example.prueba.entidades;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


@Entity
@Table(name = "CALIFICACIONES")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_CALIFICACION")
    private Integer idCalificacion;

    @Column(name = "FK_ID_ESTUDIANTE_CURSO")
    private Integer fkIdEstudianteCurso;

    @Column(name = "CALIFICACION")
    private Integer calificacion;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ESTUDIANTE_CURSO", insertable = false, updatable = false)
    @JsonManagedReference
    private EstudiantesCurso estudianteCurso;

    public EstudiantesCurso getEstudianteCurso() {
        return estudianteCurso;
    }

    public void setEstudianteCurso(EstudiantesCurso estudianteCurso) {
        this.estudianteCurso = estudianteCurso;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Integer getFkIdEstudianteCurso() {
        return fkIdEstudianteCurso;
    }

    public void setFkIdEstudianteCurso(Integer fkIdEstudianteCurso) {
        this.fkIdEstudianteCurso = fkIdEstudianteCurso;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
}
