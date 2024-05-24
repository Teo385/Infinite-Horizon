package com.example.prueba.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPLEADO")
    private Integer idEmpleado;

    @Column(name = "FK_ID_USUARIO")
    private Integer fkIdUsuario;

    @OneToOne
    @JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "ID_USUARIO",insertable = false, updatable = false)
    @JsonBackReference
    private Usuario usuario;

    @Column(name = "AREA")
    private String area;

    @Column(name = "FECHA_CONTRATACION")
    private LocalDateTime fechaContratacion;

    @Column(name = "CARGO")
    private String cargo;

    public Integer getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Integer fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDateTime getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDateTime fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
