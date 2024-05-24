package com.example.prueba.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PROFESORES")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROFESOR")
    private Integer idProfesor;

    @Column(name = "FK_ID_USUARIO")
    private Integer fkIdUsuario;

    @OneToOne
    @JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "ID_USUARIO",insertable = false, updatable = false)
    @JsonBackReference
    private Usuario usuario;

    @Column(name = "DEPARTAMENTO")
    private String departamento;

    @Column(name = "FECHA_CONTRATACION")
    private LocalDateTime fechaContratacion;

    @Column(name = "ESPECIALIZACION")
    private String especializacion;




//    @OneToMany(mappedBy = "profesor")
//    private List<ProfesoresAula> profesor;
//
//    @OneToMany(mappedBy = "profesor")
//    private List<Curso>  cursos;
//
//    @OneToMany(mappedBy = "jefeDepartamentoProfesor")
//    private List<Departamento>  departamentos;


//    public List<ProfesoresAula> getProfesor() {
//        return profesor;
//    }
//
//    public void setProfesor(List<ProfesoresAula> profesor) {
//        this.profesor = profesor;
//    }
//
//    public List<Curso> getCursos() {
//        return cursos;
//    }
//
//    public void setCursos(List<Curso> cursos) {
//        this.cursos = cursos;
//    }
//
//    public List<Departamento> getDepartamentos() {
//        return departamentos;
//    }
//
//    public void setDepartamentos(List<Departamento> departamentos) {
//        this.departamentos = departamentos;
//    }


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

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }


    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public LocalDateTime getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDateTime fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }
}
