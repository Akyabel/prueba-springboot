package com.apiescuela.demo.controllers;

import com.apiescuela.demo.entities.Estudiante;
import com.apiescuela.demo.exceptions.EmptyException;
import com.apiescuela.demo.exceptions.NotFoundException;
import com.apiescuela.demo.service.ServiceEstudianteI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escuela")
public class EstudianteController {

    //La anotación Autowired ayuda a hacer la inyección de dependencias.
    @Autowired
    ServiceEstudianteI serviceEstudianteI;

    @GetMapping("/estudiante")
    public List<Estudiante> listarEstudiantes(){
        return serviceEstudianteI.listarEstudiantes();
    }

    //@PathVariable sirve para indicar qué se está enviando el parámetro por la url
    @GetMapping("/estudiante/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable Long id) throws NotFoundException {
        Estudiante estudiante = serviceEstudianteI.obtenerEstudiante(id);
        if (estudiante == null){
            throw new NotFoundException("Estudiante no encontrado");

        }
        return ResponseEntity.ok(estudiante);
    }

    @PostMapping("/estudiante")
    public ResponseEntity<Estudiante> crearEstudiante(@Valid @RequestBody Estudiante estudiante){
        if (estudiante.getNombre() == null || estudiante.getNombre().isBlank()){
                throw new EmptyException("El alumno está vacío", HttpStatus.BAD_REQUEST, "ERROR 20");
        } else {
            Estudiante estudianteCreado = serviceEstudianteI.crearEstudiante(estudiante);
            return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
        }
    }
}
