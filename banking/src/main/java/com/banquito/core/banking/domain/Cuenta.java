package com.banquito.core.banking.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Version;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CUENTA")
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "COD_CLIENTE")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "COD_TIPO_CUENTA")
    private TipoCuenta tipoCuenta;

    @OneToMany(mappedBy = "cuenta")
    private List<Transaccion> transacciones;

    @OneToMany(mappedBy = "cuenta")
    private List<CuentaIntervinientes> cuentaIntervinientes;

    @Column(name = "NUMERO_CUENTA", nullable = false)
    private String numeroCuenta;

    @Column(name = "SALDO_CONTABLE", nullable = false)
    private BigDecimal saldoContable;

    @Column(name = "SALDO_DISPONIBLE", nullable = false)
    private BigDecimal saldoDisponible;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoCambio;

    @Version
    private long version;

    public Cuenta(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        Cuenta other = (Cuenta) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cuenta [codigo=" + codigo + ", cliente=" + cliente + ", tipoCuenta=" + tipoCuenta + ", transacciones="
                + transacciones + ", cuentaIntervinientes=" + cuentaIntervinientes + ", numeroCuenta=" + numeroCuenta
                + ", saldoContable=" + saldoContable + ", saldoDisponible=" + saldoDisponible + ", estado=" + estado
                + ", fechaCreacion=" + fechaCreacion + ", fechaUltimoCambio=" + fechaUltimoCambio + ", version="
                + version + "]";
    }

}
