package com.banquito.core.banking.cuentas.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TRANSACCION")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_TRANSACCION", nullable = false)
    private Long codigo;

    @ManyToOne()
    @JoinColumn(name = "COD_CUENTA")
    private Cuenta cuenta;

    /*
     * OPCIONAL
     * 
     * @Column(name = "COD_CUENTA", nullable = false)
     * private Long codigoCuenta;
     */

    @Column(name = "COD_UNICO", nullable = false, length = 64)
    private String codigoUnico;

    @Column(name = "TIPO_AFECTACION", nullable = false, length = 1)
    private String tipoAfectacion;

    @Column(name = "VALOR_DEBE", nullable = false, precision = 18, scale = 2)
    private long valorDebe;

    @Column(name = "VALOR_HABER", nullable = false, precision = 18, scale = 2)
    private long valorHaber;

    @Column(name = "TIPO_TRANSACCION", nullable = false, length = 8)
    private String tipoTransaccion;

    @Column(name = "DETALLE", nullable = false, length = 50)
    private String detalle;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaCreacion;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "FECHA_AFECTACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaAfectacion;

    @Version
    private long version;

    public Transaccion(Long codigo) {
        this.codigo = codigo;
    }

}
