package com.banquito.core.banking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CREDITO_INTERVINIENTE")
public class CreditoInterviniente {

    @EmbeddedId
    private CreditoIntervinientePK intervinientePK;

    @Column(name = "TIPO", nullable = false, length = 3)
    private String tipo;

    @ManyToOne()
    @JoinColumn(name = "COD_CLIENTE")
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "COD_CREDITO")
    private Credito credito;

    public CreditoInterviniente() {
    }

    public CreditoInterviniente(CreditoIntervinientePK intervinientePK) {
        this.intervinientePK = intervinientePK;
    }

}
