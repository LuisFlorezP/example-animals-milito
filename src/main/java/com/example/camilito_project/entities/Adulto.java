package com.example.camilito_project.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "adulto_entity")
public class Adulto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adulto", nullable = false)
    private Long idAdulto;
    @Column(nullable = false)
    private String nombre;
    @OneToMany(mappedBy = "adulto", cascade = CascadeType.ALL)
    private List<AdultoNinho> adultoNinhos;
    @OneToOne(mappedBy = "adulto", cascade = CascadeType.ALL)
    private Tickete tickete;

    public Long getIdAdulto() {
        return idAdulto;
    }

    public void setIdAdulto(Long idAdulto) {
        this.idAdulto = idAdulto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AdultoNinho> getAdultoNinhos() {
        return adultoNinhos;
    }

    public void setAdultoNinhos(List<AdultoNinho> adultoNinhos) {
        this.adultoNinhos = adultoNinhos;
    }

    public Tickete getTickete() {
        return tickete;
    }

    public void setTickete(Tickete tickete) {
        this.tickete = tickete;
    }
}
