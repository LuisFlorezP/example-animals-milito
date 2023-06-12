package com.example.camilito_project.controllers;

import com.example.camilito_project.entities.Habitad;
import com.example.camilito_project.services.HabitadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habitads")
public class HabitadController {

    @Autowired
    private HabitadService service;

    @GetMapping("/all")
    public ResponseEntity vertodos() {
        try {
            return new ResponseEntity<>(service.vertodos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity verUno(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.verUno(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity crear(@RequestBody Habitad habitad) {
        try {
            return new ResponseEntity<>(service.crear(habitad), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody Habitad habitad) {
        try {
            return new ResponseEntity<>(service.actualizar(id, habitad), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity borrar(@PathVariable Long id) {
        try {
            if (service.borrar(id)) {
                return ResponseEntity.noContent().build();
            }
            throw new Exception("No se pudo borrar");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
