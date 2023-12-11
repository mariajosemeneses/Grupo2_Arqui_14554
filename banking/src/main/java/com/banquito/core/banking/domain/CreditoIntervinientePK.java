package com.banquito.core.banking.domain;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class CreditoIntervinientePK implements Serializable {

    @Column(name = "COD_CREDITO", nullable = false)
    private Long codCredito;

    @Column(name = "COD_CLIENTE", nullable = false)
    private Long codCliente;

    public CreditoIntervinientePK(Long codCredito, Long codCliente) {
        this.codCredito = codCredito;
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCredito == null) ? 0 : codCredito.hashCode());
        result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreditoIntervinientePK other = (CreditoIntervinientePK) obj;
        if (codCredito == null) {
            if (other.codCredito != null)
                return false;
        } else if (!codCredito.equals(other.codCredito))
            return false;
        if (codCliente == null) {
            if (other.codCliente != null)
                return false;
        } else if (!codCliente.equals(other.codCliente))
            return false;
        return true;
    }

}
