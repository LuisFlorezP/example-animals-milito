package com.example.camilito_project.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ninho_entity")
public class Ninho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ninho", nullable = false)
    private Long idNinho;
    @Column(nullable = false)
    private String nombre;

    public Long getIdNinho() {
        return idNinho;
    }

    public void setIdNinho(Long idNinho) {
        this.idNinho = idNinho;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
