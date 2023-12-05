package com.banquito.core.banking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.*;

@Entity
@Table(name = "PARTICIPES")
public class Participes {

    @Id
    @Column(name = "COD_CREDITO", nullable = false)
    private Long codCredito;

    @Id
    @Column(name = "COD_CUENTA", nullable = false)
    private Long codCuenta;

    public Long getCodCredito() {
        return codCredito;
    }

    public void setCodCredito(Long codCredito) {
        this.codCredito = codCredito;
    }

    public Long getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(Long codCuenta) {
        this.codCuenta = codCuenta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCredito == null) ? 0 : codCredito.hashCode());
        result = prime * result + ((codCuenta == null) ? 0 : codCuenta.hashCode());
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
        Participes other = (Participes) obj;
        if (codCredito == null) {
            if (other.codCredito != null)
                return false;
        } else if (!codCredito.equals(other.codCredito))
            return false;
        if (codCuenta == null) {
            if (other.codCuenta != null)
                return false;
        } else if (!codCuenta.equals(other.codCuenta))
            return false;
        return true;
    }

}
