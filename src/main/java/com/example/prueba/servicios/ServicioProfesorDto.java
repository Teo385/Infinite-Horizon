package com.example.prueba.servicios;

import com.example.prueba.dto.ProfesorDto;
import com.example.prueba.entidades.*;
import com.example.prueba.repositorios.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioProfesorDto {

    @Autowired
    private ProfesorRepository profesorRepository;


    public ProfesorDto profesorDto(Integer idProfesor) {
        Profesor profesor = profesorRepository.findById(idProfesor).orElse(null);

        if (profesor == null) {
            return null;
        }

        ProfesorDto dto = new ProfesorDto();

        dto.setNombreProfesor(profesor.getUsuario().getNombre());

        dto.setApellidoProfesor(profesor.getUsuario().getApellido());

        List<String> NombreDepa = new ArrayList<>();
        for (Departamento dp : profesor.getDepartamentos()) {
            NombreDepa.add(dp.getNombreDepartamento());
        }
        dto.setNombreDepartamento(String.join(", ", NombreDepa));

        List<String> JefeDepartamento = new ArrayList<>();
        for (Departamento dp : profesor.getDepartamentos()) {
            JefeDepartamento.add(dp.getJefeDepartamento());
        }
        dto.setJefeDepartamento(String.join(", ", JefeDepartamento));

        List<Integer> NumeroAula = new ArrayList<>();
        for (ProfesoresAula pa : profesor.getProfesoresAula()) {
            NumeroAula.add(pa.getAula().getNumeroAula());
        }
        dto.setNumeroAula(NumeroAula.stream().findFirst().orElse(0));

        List<String> edificio = new ArrayList<>();
        for (ProfesoresAula pa : profesor.getProfesoresAula()){
            edificio.add(pa.getAula().getEdificio());
        }
        dto.setEdificioAula(String.join(", ", edificio));

        List<String> nombreCurso = new ArrayList<>();
        for (Curso c : profesor.getCursos()){
            nombreCurso.add(c.getNombreCurso());
        }
        dto.setNombreCurso(String.join(", ", nombreCurso));

        List<String> horaCurso = new ArrayList<>();
        for (Curso c : profesor.getCursos()){
            horaCurso.add(c.getHorario());
        }
        dto.setHoraCurso(String.join(", ", horaCurso));

        dto.setEspecializacionProfesor(profesor.getEspecializacion());
        dto.setIdUsuario(profesor.getFkIdUsuario());

        return dto;
    }


    public List<ProfesorDto> profesoresDto() {
        List<Profesor> profesores = profesorRepository.findAll();

        List<ProfesorDto> profesoresDto = new ArrayList<>();

        for (Profesor profesor : profesores) {
            ProfesorDto dto = new ProfesorDto();

            dto.setNombreProfesor(profesor.getUsuario().getNombre());
            dto.setApellidoProfesor(profesor.getUsuario().getApellido());

            List<String> NombreDepa = new ArrayList<>();
            for (Departamento dp : profesor.getDepartamentos()) {
                NombreDepa.add(dp.getNombreDepartamento());
            }
            dto.setNombreDepartamento(String.join(", ", NombreDepa));

            List<String> JefeDepartamento = new ArrayList<>();
            for (Departamento dp : profesor.getDepartamentos()) {
                JefeDepartamento.add(dp.getJefeDepartamento());
            }
            dto.setJefeDepartamento(String.join(", ", JefeDepartamento));

            List<Integer> NumeroAula = new ArrayList<>();
            for (ProfesoresAula pa : profesor.getProfesoresAula()) {
                NumeroAula.add(pa.getAula().getNumeroAula());
            }
            dto.setNumeroAula(NumeroAula.stream().findFirst().orElse(0));

            List<String> edificio = new ArrayList<>();
            for (ProfesoresAula pa : profesor.getProfesoresAula()){
                edificio.add(pa.getAula().getEdificio());
            }
            dto.setEdificioAula(String.join(", ", edificio));

            List<String> nombreCurso = new ArrayList<>();
            for (Curso c : profesor.getCursos()){
                nombreCurso.add(c.getNombreCurso());
            }
            dto.setNombreCurso(String.join(", ", nombreCurso));

            List<String> horaCurso = new ArrayList<>();
            for (Curso c : profesor.getCursos()){
                horaCurso.add(c.getHorario());
            }
            dto.setHoraCurso(String.join(", ", horaCurso));

            dto.setEspecializacionProfesor(profesor.getEspecializacion());

            dto.setIdUsuario(profesor.getFkIdUsuario());

            profesoresDto.add(dto);
        }

        return profesoresDto;
    }


}