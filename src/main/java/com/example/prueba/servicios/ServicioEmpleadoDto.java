package com.example.prueba.servicios;

import com.example.prueba.dto.EmpleadosDto;
import com.example.prueba.entidades.Empleado;
import com.example.prueba.repositorios.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioEmpleadoDto {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadosDto empleadoDto(Integer idEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado).orElse(null);

        if (empleado == null) {
            return null;
        }

        EmpleadosDto dto = new EmpleadosDto();

        dto.setNombreEmpleado(empleado.getUsuario().getNombre());

        dto.setApellidoEmpleado(empleado.getUsuario().getApellido());

        dto.setCargo(empleado.getCargo());

        dto.setArea(empleado.getArea());

        dto.setIdUsuario(empleado.getFkIdUsuario());

        return dto;
    }

    public List<EmpleadosDto> empleadosDtos() {
        List<Empleado> empleados = empleadoRepository.findAll();

        List<EmpleadosDto> empleadosDto = new ArrayList<>();

        for (Empleado empleado : empleados) {
            EmpleadosDto dto = new EmpleadosDto();

            dto.setNombreEmpleado(empleado.getUsuario().getNombre());

            dto.setApellidoEmpleado(empleado.getUsuario().getApellido());

            dto.setCargo(empleado.getCargo());

            dto.setArea(empleado.getArea());

            dto.setIdUsuario(empleado.getFkIdUsuario());

            empleadosDto.add(dto);
        }

        return empleadosDto;
    }

}
