package com.example.camilito_project.services;

import com.example.camilito_project.entities.Animal;
import com.example.camilito_project.entities.Habitad;
import com.example.camilito_project.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public List<Animal> vertodos() throws Exception {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new Exception("No se encontraron registros.");
        }
    }

    public Animal verUno(Long id) throws Exception {
        try {
            Optional<Animal> animal = repository.findById(id);
            if (animal.isPresent()) {
                return animal.get();
            }
            throw new Exception("No encontre el animal.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Animal crear(Animal animal) throws Exception {
        try {
            return repository.save(animal);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Animal actualizar(Long id, Animal animal) throws Exception {
        try {
            Optional<Animal> search = repository.findById(id);
            if (search.isPresent()) {
                Animal data = search.get();
                data.setNombre(animal.getNombre());
                data.setEdad(animal.getEdad());
                data.setHabitad(animal.getHabitad());
                return repository.save(data);
            }
            throw new Exception("No existe.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean borrar(Long id) throws Exception {
        try {
            if (repository.findById(id).isPresent()) {
                repository.deleteById(id);
                return true;
            }
            throw new Exception("No se pudo borrar.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
