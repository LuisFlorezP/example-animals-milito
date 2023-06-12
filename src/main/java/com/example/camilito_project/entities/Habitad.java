package com.example.camilito_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "habitad_entity")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Habitad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitad", nullable = false)
    private Long idHabitad;
    @Column(nullable = false)
    private String nombre;
    @OneToMany(mappedBy = "habitad", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Animal> animals;

    public Long getIdHabitad() {
        return idHabitad;
    }

    public void setIdHabitad(Long idHabitad) {
        this.idHabitad = idHabitad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
