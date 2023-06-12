package com.example.camilito_project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AdultoNinhoPk implements Serializable {

    @Column(name = "id_adulto")
    private Long idAdulto;
    @Column(name = "id_ninho")
    private Long idNinho;

    public Long getIdAdulto() {
        return idAdulto;
    }

    public void setIdAdulto(Long idAdulto) {
        this.idAdulto = idAdulto;
    }

    public Long getIdNinho() {
        return idNinho;
    }

    public void setIdNinho(Long idNinho) {
        this.idNinho = idNinho;
    }
}
