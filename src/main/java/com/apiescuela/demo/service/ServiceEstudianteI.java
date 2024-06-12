package com.apiescuela.demo.service;

import com.apiescuela.demo.entities.Estudiante;

import java.util.List;

public interface ServiceEstudianteI {
    List<Estudiante> listarEstudiantes();
    Estudiante obtenerEstudiante(Long id);
    Estudiante crearEstudiante(Estudiante estudiante);
}
