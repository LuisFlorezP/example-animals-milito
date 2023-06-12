package com.example.camilito_project.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tickete_entity")
public class Tickete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tickete", nullable = false)
    private Long idTickete;
    @OneToOne(optional = false)
    @JoinColumn(name = "id_adulto", nullable = false)
    private Adulto adulto;

    public Long getIdTickete() {
        return idTickete;
    }

    public void setIdTickete(Long idTickete) {
        this.idTickete = idTickete;
    }

    public Adulto getAdulto() {
        return adulto;
    }

    public void setAdulto(Adulto adulto) {
        this.adulto = adulto;
    }
}
