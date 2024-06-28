package com.example.prueba.servicios;

import com.example.prueba.dto.EstudianteDto;
import com.example.prueba.entidades.*;
import com.example.prueba.repositorios.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioEstudianteDto {

    @Autowired
    private EstudianteRepository estudianteRepository;


    public EstudianteDto obtenerInformacionEstudiante(Integer idEstudiante) {
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElse(null);

        if (estudiante == null) {
            return null;
        }

        EstudianteDto dto = new EstudianteDto();
        dto.setNombreEstudiante(estudiante.getUsuario().getNombre());
        dto.setApellidoEstudiante(estudiante.getUsuario().getApellido());
        dto.setCarrera(estudiante.getCarrera());
        List<String> nombresCursos = new ArrayList<>();
        for (EstudiantesCurso ec : estudiante.getEstudiantesCurso()) {
            nombresCursos.add(ec.getCurso().getNombreCurso());
        }
        dto.setNombresCursos(nombresCursos);
        List<String> nombreProfesores = new ArrayList<>();
        for (EstudiantesCurso ec : estudiante.getEstudiantesCurso()) {
            nombreProfesores.add(ec.getCurso().getProfesor().getUsuario().getNombre());
        }
        dto.setNombreProfesor(String.join(", ", nombreProfesores));
        List<String> apellidoProfesores = new ArrayList<>();
        for (EstudiantesCurso ec : estudiante.getEstudiantesCurso()) {
            apellidoProfesores.add(ec.getCurso().getProfesor().getUsuario().getApellido());
        }
        dto.setApellidoProfesor(String.join(", ", apellidoProfesores));
        List<Integer> numerosAula = new ArrayList<>();
        for (EstudiantesCurso ec : estudiante.getEstudiantesCurso()) {
            for (ProfesoresAula pa : ec.getCurso().getProfesor().getProfesoresAula()) {
                numerosAula.add(pa.getAula().getNumeroAula());
            }
        }
        dto.setNumeroAula(numerosAula.stream().findFirst().orElse(0));
        List<String> pisoAula = new ArrayList<>();
        for (EstudiantesCurso ec : estudiante.getEstudiantesCurso()) {
            Curso curso = ec.getCurso();
            Profesor profesor = curso.getProfesor();
            for (ProfesoresAula pa : profesor.getProfesoresAula()) {
                pisoAula.add(pa.getAula().getUbicacion());
            }
        }
        dto.setPisoAula(String.join(", ", pisoAula));
        List<String> edificioAula = new ArrayList<>();
        for (EstudiantesCurso ec : estudiante.getEstudiantesCurso()) {
            Curso curso = ec.getCurso();
            Profesor profesor = curso.getProfesor();
            for (ProfesoresAula pa : profesor.getProfesoresAula()) {
                edificioAula.add(pa.getAula().getEdificio());
            }
        }
        dto.setEdificioAula(String.join(", ", edificioAula));
        List<Double> nota = new ArrayList<>();
        for (EstudiantesCurso ec: estudiante.getEstudiantesCurso()){
            for (Calificacion c: ec.getEstudianteCurso()){
                nota.add(c.getCalificacion());
            }
        }
        dto.setNotaFinal(nota.stream().findFirst().orElse((double) 0));
        dto.setFkIdUsuario(estudiante.getFkIdUsuario());


        return dto;
    }

    public List<EstudianteDto> obtenerInformacionTodosEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDto> dtos = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            EstudianteDto dto = new EstudianteDto();
            dto.setNombreEstudiante(estudiante.getUsuario().getNombre());
            dto.setApellidoEstudiante(estudiante.getUsuario().getApellido());
            dto.setCarrera(estudiante.getCarrera());
            List<String> nombresCursos = estudiante.getEstudiantesCurso()
                    .stream()
                    .map(ec -> ec.getCurso().getNombreCurso())
                    .collect(Collectors.toList());
            dto.setNombresCursos(nombresCursos);

            List<String> nombreProfesores = estudiante.getEstudiantesCurso()
                    .stream()
                    .map(ec -> ec.getCurso().getProfesor().getUsuario().getNombre())
                    .distinct()
                    .collect(Collectors.toList());
            dto.setNombreProfesor(String.join(", ", nombreProfesores));

            List<String> apellidoProfesores = estudiante.getEstudiantesCurso()
                    .stream()
                    .map(ec -> ec.getCurso().getProfesor().getUsuario().getApellido())
                    .distinct()
                    .collect(Collectors.toList());
            dto.setApellidoProfesor(String.join(", ", apellidoProfesores));

            List<Integer> numerosAula = estudiante.getEstudiantesCurso()
                    .stream()
                    .flatMap(ec -> ec.getCurso().getProfesor().getProfesoresAula().stream())
                    .map(pa -> pa.getAula().getNumeroAula())
                    .distinct()
                    .collect(Collectors.toList());
            dto.setNumeroAula(numerosAula.stream().findFirst().orElse(0));

            List<String> pisoAula = estudiante.getEstudiantesCurso()
                    .stream()
                    .flatMap(ec -> ec.getCurso().getProfesor().getProfesoresAula().stream())
                    .map(pa -> pa.getAula().getUbicacion())
                    .distinct()
                    .collect(Collectors.toList());
            dto.setPisoAula(String.join(", ", pisoAula));

            List<String> edificioAula = estudiante.getEstudiantesCurso()
                    .stream()
                    .flatMap(ec -> ec.getCurso().getProfesor().getProfesoresAula().stream())
                    .map(pa -> pa.getAula().getEdificio())
                    .distinct()
                    .collect(Collectors.toList());
            dto.setEdificioAula(String.join(", ", edificioAula));

            List<Double> nota = estudiante.getEstudiantesCurso()
                    .stream()
                    .flatMap(ec -> ec.getEstudianteCurso().stream())
                    .map(Calificacion::getCalificacion)
                    .collect(Collectors.toList());
            dto.setNotaFinal(nota.stream().findFirst().orElse(0.0));

            dto.setFkIdUsuario(estudiante.getFkIdUsuario());

            dtos.add(dto);
        }

        return dtos;
    }

    public List<EstudianteDto> obtenerEstudiantesPorCurso(String nombreCurso) {
        return obtenerInformacionTodosEstudiantes()
                .stream()
                .filter(dto -> dto.getNombresCursos().contains(nombreCurso))
                .collect(Collectors.toList());
    }
}
