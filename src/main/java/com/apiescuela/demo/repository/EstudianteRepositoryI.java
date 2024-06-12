package com.apiescuela.demo.repository;

import com.apiescuela.demo.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositoryI extends JpaRepository<Estudiante, Long> {

}
