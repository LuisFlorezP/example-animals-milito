package com.example.camilito_project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "animal_entity")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal", nullable = false)
    private Long idAnimal;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Integer edad;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_habitad", nullable = false)
    @JsonBackReference
    private Habitad habitad;

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Habitad getHabitad() {
        return habitad;
    }

    public void setHabitad(Habitad habitad) {
        this.habitad = habitad;
    }
}
