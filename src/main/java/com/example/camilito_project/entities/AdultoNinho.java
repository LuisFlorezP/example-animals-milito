package com.example.camilito_project.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "adulto_ninho")
public class AdultoNinho {

    @EmbeddedId
    private AdultoNinhoPk idAdultoNinho;
    @ManyToOne
    @MapsId("idAdulto")
    @JoinColumn(name = "id_adulto", insertable = false, updatable = false)
    private Adulto adulto;
    @ManyToOne
    @JoinColumn(name = "id_ninho", insertable = false, updatable = false)
    private Ninho ninho;

    public AdultoNinhoPk getIdAdultoNinho() {
        return idAdultoNinho;
    }

    public void setIdAdultoNinho(AdultoNinhoPk idAdultoNinho) {
        this.idAdultoNinho = idAdultoNinho;
    }

    public Adulto getAdulto() {
        return adulto;
    }

    public void setAdulto(Adulto adulto) {
        this.adulto = adulto;
    }

    public Ninho getNinho() {
        return ninho;
    }

    public void setNinho(Ninho ninho) {
        this.ninho = ninho;
    }
}
