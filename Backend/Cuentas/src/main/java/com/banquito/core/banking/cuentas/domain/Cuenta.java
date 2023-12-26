package com.banquito.core.banking.cuentas.domain;


import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CUENTA")
    private long codigo;

    @ManyToOne
    @JoinColumn(name = "COD_TIPO_CUENTA")
    private TipoCuenta tipoCuenta;

    @Column(name = "NUMERO_CUENTA", nullable = false)
    private String numeroCuenta;

    @Column(name = "SALDO_CONTABLE", nullable = false, length = 18, scale = 2)
    private long saldoContable;

    @Column(name = "SALDO_DISPONIBLE", nullable = false, length = 18, scale = 2)
    private long saldoDisponible;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaCreacion;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaUltimoCambio;

    @Version
    private long version;

    public Cuenta(Long codigo) {
        this.codigo = codigo;
    }

    
    
}
