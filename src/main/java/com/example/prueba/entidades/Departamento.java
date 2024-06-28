package com.example.prueba.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEPARTAMENTO")
    private Integer idDepartamento;

    @Column(name = "NOMBRE_DEPARTAMENTO")
    private String nombreDepartamento;

    @Column(name = "EDIFICIO")
    private String edificio;

    @Column(name = "OFICINA")
    private String oficina;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "JEFE_DEPARTAMENTO")
    private String jefeDepartamento;

    @Column(name = "FK_ID_PROFESOR")
    private Integer fkIdProfesor;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROFESOR", insertable = false, updatable = false)
    @JsonIgnore
    private Profesor jefeDepartamentoProfesor;

    public Profesor getJefeDepartamentoProfesor() {
        return jefeDepartamentoProfesor;
    }

    public void setJefeDepartamentoProfesor(Profesor jefeDepartamentoProfesor) {
        this.jefeDepartamentoProfesor = jefeDepartamentoProfesor;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(String jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;
    }

    public Integer getFkIdProfesor() {
        return fkIdProfesor;
    }

    public void setFkIdProfesor(Integer fkIdProfesor) {
        this.fkIdProfesor = fkIdProfesor;
    }
}
