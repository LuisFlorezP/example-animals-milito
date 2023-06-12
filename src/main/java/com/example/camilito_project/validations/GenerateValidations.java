package com.example.camilito_project.validations;

import com.example.camilito_project.entities.Habitad;

import java.util.Optional;

public class GenerateValidations {

    public static boolean verificarNombre(String nombre) {
        return nombre == null || nombre.length() == 0;
    }

    public static boolean verificarNombreUnico(Optional<Habitad> habitad) {
        return habitad.isPresent();
    }

    public static boolean verificarMismoNombre(String guardar, String guardado) {
        return !guardar.equals(guardado);
    }
}
