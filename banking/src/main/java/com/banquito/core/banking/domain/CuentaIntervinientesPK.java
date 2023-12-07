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
public class CuentaIntervinientesPK implements Serializable {

    @Column(name = "COD_CUENTA", nullable = false)
    private Long codCuenta;

    @Column(name = "COD_CLIENTE_PERSONA", nullable = false)
    private Long codClientePersona;

    public CuentaIntervinientesPK(Long codCuenta, Long codClientePersona) {
        this.codCuenta = codCuenta;
        this.codClientePersona = codClientePersona;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCuenta == null) ? 0 : codCuenta.hashCode());
        result = prime * result + ((codClientePersona == null) ? 0 : codClientePersona.hashCode());
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
        CuentaIntervinientesPK other = (CuentaIntervinientesPK) obj;
        if (codCuenta == null) {
            if (other.codCuenta != null)
                return false;
        } else if (!codCuenta.equals(other.codCuenta))
            return false;
        if (codClientePersona == null) {
            if (other.codClientePersona != null)
                return false;
        } else if (!codClientePersona.equals(other.codClientePersona))
            return false;
        return true;
    }
}

