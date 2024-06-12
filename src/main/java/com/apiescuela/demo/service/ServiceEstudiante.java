package com.apiescuela.demo.service;

import com.apiescuela.demo.entities.Estudiante;
import com.apiescuela.demo.repository.EstudianteRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceEstudiante implements ServiceEstudianteI{

    @Autowired
    EstudianteRepositoryI estudianteRepositoryI;
    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepositoryI.findAll();
    }

    @Override
    public Estudiante obtenerEstudiante(Long id) {
        return estudianteRepositoryI.findById(id).orElse(null);
    }

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepositoryI.save(estudiante);
    }
}
