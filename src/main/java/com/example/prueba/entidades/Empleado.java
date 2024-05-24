package com.University.of.the.infinite.Horizon.persistence.entity;

import jakarta.persistence.*;



import java.time.LocalDateTime;

@Entity
@Table(name = "Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPLEADO")
    private Number idEmpleado;

    @Column(name = "FK_ID_USUARIO")
    private Number fkIdUsuario;

    @Column(name = "AREA")
    private String area;

    @Column(name = "FECHA_CONTRATACION")
    private LocalDateTime fechaContratacion;

    @Column(name = "CARGO")
    private String cargo;

    @OneToOne
    @JoinColumn(name = "FK_ID_Usuario", insertable = false, updatable = false)
    private Usuario usuario;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Number getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Number idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Number getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Number fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
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
