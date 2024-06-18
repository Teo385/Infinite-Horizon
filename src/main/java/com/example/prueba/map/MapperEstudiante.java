package com.example.prueba.map;

import com.example.prueba.dto.EstudianteDto;
import com.example.prueba.entidades.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

//@Mapper
//public interface MapperEstudiante {
//
//    @Mappings({
//            @Mapping(target = "nombreEstudiante", source = "estudiante.usuario.nombre"),
//            @Mapping(target = "apellidoEstudiante", source = "estudiante.usuario.apellido"),
//            @Mapping(target = "carrera", source = "estudiante.carrera"),
//            @Mapping(target = "nombreCurso", source = "curso.nombreCurso"),
//            @Mapping(target = "nombreProfesor", source = "profesor.usuario.nombre"),
//            @Mapping(target = "apellidoProfesor", source = "profesor.usuario.apellido"),
//            @Mapping(target = "numeroAula", source = "curso.profesor.profesoresAula.aula.numeroAula"),
//            @Mapping(target = "pisoAula", source = "curso.aula.piso"),
//            @Mapping(target = "edificioAula", source = "curso.aula.edificio")
//    })
//    EstudianteDto estudianteToDTO(Estudiante estudiante, Curso curso, Profesor profesor);

//    default List<String> mapCursos(List<EstudiantesCurso> estudiantesCurso) {
//        return estudiantesCurso.stream()
//                .map(estCurso -> estCurso.getCurso().getNombreCurso())
//                .collect(Collectors.toList());
//    }
//
//    default String mapProfesorNombre(List<EstudiantesCurso> estudiantesCurso) {
//        return estudiantesCurso.stream()
//                .map(estCurso -> estCurso.getCurso().getProfesor().getUsuario().getNombre())
//                .findFirst()
//                .orElse(null);
//    }
//
//    default String mapProfesorApellido(List<EstudiantesCurso> estudiantesCurso) {
//        return estudiantesCurso.stream()
//                .map(estCurso -> estCurso.getCurso().getProfesor().getUsuario().getApellido())
//                .findFirst()
//                .orElse(null);
//    }
//
//    default Integer mapNumeroAula(List<EstudiantesCurso> estudiantesCurso) {
//        return estudiantesCurso.stream()
//                .flatMap(estCurso -> estCurso.getCurso().getProfesor().getProfesoresAula().stream())
//                .map(ProfesoresAula::getAula)
//                .map(Aula::getNumeroAula)
//                .findFirst()
//                .orElse(null);
//    }
//
//    default String mapPiso(List<EstudiantesCurso> estudiantesCurso) {
//        return estudiantesCurso.stream()
//                .flatMap(estCurso -> estCurso.getCurso().getProfesor().getProfesoresAula().stream())
//                .map(ProfesoresAula::getAula)
//                .map(Aula::getUbicacion)
//                .findFirst()
//                .orElse(null);
//    }
//
//    default String mapEdificio(List<EstudiantesCurso> estudiantesCurso) {
//        return estudiantesCurso.stream()
//                .flatMap(estCurso -> estCurso.getCurso().getProfesor().getProfesoresAula().stream())
//                .map(ProfesoresAula::getAula)
//                .map(Aula::getEdificio)
//                .findFirst()
//                .orElse(null);
//    }
//}
