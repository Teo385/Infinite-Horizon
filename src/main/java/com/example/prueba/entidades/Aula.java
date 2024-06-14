package com.example.prueba.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "AULAS")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AULA")
    private Integer idAula;

    @Column(name = "NUMERO_AULA")
    private Integer numeroAula;

    @Column(name = "CAPACIDAD")
    private Integer capacidad;

    @Column(name = "EDIFICIO")
    private String edificio;

    @Column(name = "UBICACION")
    private String ubicacion;

    @Column(name = "EQUIPAMIENTO")
    private String equipamiento;

    // Constructor, getters y setters
    public Aula() {}

    public Aula(Integer idAula, Integer numeroAula, Integer capacidad, String edificio, String ubicacion, String equipamiento) {
        this.idAula = idAula;
        this.numeroAula = numeroAula;
        this.capacidad = capacidad;
        this.edificio = edificio;
        this.ubicacion = ubicacion;
        this.equipamiento = equipamiento;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public Integer getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(Integer numeroAula) {
        this.numeroAula = numeroAula;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }
}
