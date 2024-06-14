package com.example.prueba.entidades;

import jakarta.persistence.*;


@Entity
@Table(name = "PROFESORES_AULAS")
public class ProfesoresAula {
    @EmbeddedId
    private ProfesoresAulaPK id;

    @ManyToOne
    @JoinColumn(name = "FK_ID_AULA", insertable = false, updatable = false)
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROFESOR", insertable = false, updatable = false)
    private Profesor profesor;

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ProfesoresAulaPK getId() {
        return id;
    }

    public void setId(ProfesoresAulaPK id) {
        this.id = id;
    }
}
