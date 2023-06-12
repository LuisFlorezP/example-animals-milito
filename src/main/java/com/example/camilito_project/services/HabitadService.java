package com.example.camilito_project.services;

import com.example.camilito_project.entities.Habitad;
import com.example.camilito_project.repositories.HabitadRepository;
import com.example.camilito_project.validations.GenerateValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitadService extends GenerateValidations {

    @Autowired
    private HabitadRepository repository;

    public List<Habitad> vertodos() throws Exception {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new Exception("No se encontraron registros.");
        }
    }

    public Habitad verUno(Long id) throws Exception {
        try {
            Optional<Habitad> habitad = repository.findById(id);
            if (habitad.isPresent()) {
                return habitad.get();
            }
            throw new Exception("No encontre el habitad.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Habitad crear(Habitad habitad) throws Exception {
        try {
            if (verificarNombre(habitad.getNombre())) {
                throw new Exception("Debes registrar un nombre.");
            } else if (verificarNombreUnico(repository.findByNombre(habitad.getNombre()))) {
                throw new Exception("Ingresa un nombre único y diferente.");
            }
            return repository.save(habitad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Habitad actualizar(Long id, Habitad habitad) throws Exception {
        try {
            Optional<Habitad> search = repository.findById(id);
            if (search.isPresent()) {
                if (verificarNombre(habitad.getNombre())) {
                    throw new Exception("Debes registrar un nombre.");
                }
                Optional<Habitad> habitadNombre = repository.findByNombre(habitad.getNombre());
                if (verificarNombreUnico(habitadNombre) && verificarMismoNombre(habitadNombre.get().getNombre(), search.get().getNombre())) {
                    throw new Exception("Ingresa un nombre único y diferente.");
                }
                Habitad data = search.get();
                data.setNombre(habitad.getNombre());
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
