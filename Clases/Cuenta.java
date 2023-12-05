package com.banquito.core.banking.domain;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity

@Table(name = "Cuenta")
public class Cuenta {
    @Id
    @Column(name = "COD_CUENTA", nullable = false)
       private Long codCreditoTransaccionSerial;
    @Column(name = "COD_TIPO_CUENTA", nullable = false,length = 10)
       private String codTipoCuenta;
    @Column(name = "COD_CLIENTE", nullable = false,length = 4)
       private Long codCliente;
    @Column(name = "NUMERO_CUENTA", nullable = false)
       private String numeroCuenta;
    @Column(name = "SALDO_CONTABLE", nullable = false,precision = 18, scale = 2)
       private BigDecimal saldoContable;
    @Column(name = "SALDO_DISPONIBLE", nullable = false,precision = 18, scale = 2)
       private BigDecimal saldoDisponible;
    @Column(name = "ESTADO", nullable = false,length = 3)
       private String estado;

    @Column(name = "FECHA_CREACION", nullable = false)
       private LocalDateTime fechaCreacion;

     @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
       private LocalDateTime fechaUltimoCambio;

    public Long getCodCreditoTransaccionSerial() {
        return codCreditoTransaccionSerial;
    }

    public void setCodCreditoTransaccionSerial(Long codCreditoTransaccionSerial) {
        this.codCreditoTransaccionSerial = codCreditoTransaccionSerial;
    }

    public String getCodTipoCuenta() {
        return codTipoCuenta;
    }

    public void setCodTipoCuenta(String codTipoCuenta) {
        this.codTipoCuenta = codTipoCuenta;
    }

    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldoContable() {
        return saldoContable;
    }

    public void setSaldoContable(BigDecimal saldoContable) {
        this.saldoContable = saldoContable;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaUltimoCambio() {
        return fechaUltimoCambio;
    }

    public void setFechaUltimoCambio(LocalDateTime fechaUltimoCambio) {
        this.fechaUltimoCambio = fechaUltimoCambio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCreditoTransaccionSerial == null) ? 0 : codCreditoTransaccionSerial.hashCode());
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
        if (codCreditoTransaccionSerial == null) {
            if (other.codCreditoTransaccionSerial != null)
                return false;
        } else if (!codCreditoTransaccionSerial.equals(other.codCreditoTransaccionSerial))
            return false;
        return true;
    }
       
       
}
