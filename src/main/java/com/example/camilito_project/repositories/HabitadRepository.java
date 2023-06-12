package com.example.camilito_project.repositories;

import com.example.camilito_project.entities.Habitad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabitadRepository extends JpaRepository<Habitad, Long> {

    Optional<Habitad> findByNombre(String nombre);
}
