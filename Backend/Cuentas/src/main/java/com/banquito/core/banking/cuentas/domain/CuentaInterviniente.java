package com.banquito.core.banking.cuentas.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CUENTA_INTERVINIENTES")
public class CuentaInterviniente {

    @EmbeddedId
    private CuentaIntervinientePK cuentaIntervinientePK;

    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaInicio;

    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaFin;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Version
    private long version;



}
