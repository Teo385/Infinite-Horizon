package com.example.prueba.servicios;
import com.example.prueba.entidades.Aula;
import com.example.prueba.repositorios.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAula {

    @Autowired
    AulaRepository aulasRepository;

    public List<Aula> getAllAulas() {
        return aulasRepository.findAll();
    }

    public Aula getAulaById(Integer id) {
        return aulasRepository.findById(id).orElse(null);
    }

    public Aula createAula(Aula aula) {
        return aulasRepository.save(aula);
    }

    public Aula updateAula(Aula aula) {
        return aulasRepository.save(aula);
    }

    public void deleteAulaById(Integer id) {
        aulasRepository.deleteById(id);
    }
}

