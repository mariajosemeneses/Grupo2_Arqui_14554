package com.banquito.core.banking.cuentas.domain;


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
public class CuentaIntervinientePK implements Serializable {

    @Column(name = "COD_CUENTA", nullable = false)
    private long codCuenta;

    @Column(name = "COD_CLIENTE_PERSONA", nullable = false)
    private long codClientePersona;

    public CuentaIntervinientePK(Long codCuenta, Long codClientePersona) {
        this.codCuenta = codCuenta;
        this.codClientePersona = codClientePersona;
    }

    

    
}

