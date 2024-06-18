package com.example.prueba.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable

public class ProfesoresAulaPK  implements Serializable {
    @Column(name = "FK_ID_PROFESOR")
    private Integer fkIdProfesor;
    @Column(name = "FK_ID_AULA")
    private Integer fkIdAula;

    public Integer getFkIdProfesor() {
        return fkIdProfesor;
    }

    public void setFkIdProfesor(Integer fkIdProfesor) {
        this.fkIdProfesor = fkIdProfesor;
    }

    public Integer getFkIdAula() {
        return fkIdAula;
    }

    public void setFkIdAula(Integer fkIdAula) {
        this.fkIdAula = fkIdAula;
    }
}
