package com.example.prueba.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable

public class ProfesoresAulaPK  implements Serializable {
    @Column(name = "FK_ID_PROFESOR")
    private Number fkIdProfesor;
    @Column(name = "FK_ID_AULA")
    private Number fkIdAula;

    public Number getFkIdProfesor() {
        return fkIdProfesor;
    }

    public void setFkIdProfesor(Number fkIdProfesor) {
        this.fkIdProfesor = fkIdProfesor;
    }

    public Number getFkIdAula() {
        return fkIdAula;
    }

    public void setFkIdAula(Number fkIdAula) {
        this.fkIdAula = fkIdAula;
    }
}
