package com.banquito.core.banking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity

@Table(name = "Amortizacion")
public class Amortizacion {
    @Id
    @Column(name = "COD_AMORTIZACION", nullable = false)
       private Long codAmortizacion;

    @Column(name = "COD_CREDITO", nullable = false)
       private Long codCredito;

    @Column(name = "NUMERO_CUOTA", nullable = false, precision = 2, scale = 0)
    private BigDecimal numeroCuota;
    @Column(name = "MONTO_CUOTA", nullable = false, precision = 18, scale = 2)
    private BigDecimal montoCuota;
    @Column(name = "ESTADO_CUOTA", nullable = false, length = 3)
    private String estadoCuota;
    @Column(name = "FECHA_PAGO", nullable = false)
    private LocalDateTime  fechaPago;
     @Column(name = "FECHA_MAXIMA", nullable = false)
     private LocalDateTime  fechaMaxima;
     @Column(name = "FECHA_CUOTA", nullable = false, precision = 18, scale = 2)
    private BigDecimal fechaCuota;
    public Long getCodAmortizacion() {
        return codAmortizacion;
    }
    public void setCodAmortizacion(Long codAmortizacion) {
        this.codAmortizacion = codAmortizacion;
    }
    public Long getCodCredito() {
        return codCredito;
    }
    public void setCodCredito(Long codCredito) {
        this.codCredito = codCredito;
    }
    public BigDecimal getNumeroCuota() {
        return numeroCuota;
    }
    public void setNumeroCuota(BigDecimal numeroCuota) {
        this.numeroCuota = numeroCuota;
    }
    public BigDecimal getMontoCuota() {
        return montoCuota;
    }
    public void setMontoCuota(BigDecimal montoCuota) {
        this.montoCuota = montoCuota;
    }
    public String getEstadoCuota() {
        return estadoCuota;
    }
    public void setEstadoCuota(String estadoCuota) {
        this.estadoCuota = estadoCuota;
    }
    public LocalDateTime getFechaPago() {
        return fechaPago;
    }
    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }
    public LocalDateTime getFechaMaxima() {
        return fechaMaxima;
    }
    public void setFechaMaxima(LocalDateTime fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
    }
    public BigDecimal getFechaCuota() {
        return fechaCuota;
    }
    public void setFechaCuota(BigDecimal fechaCuota) {
        this.fechaCuota = fechaCuota;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codAmortizacion == null) ? 0 : codAmortizacion.hashCode());
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
        Amortizacion other = (Amortizacion) obj;
        if (codAmortizacion == null) {
            if (other.codAmortizacion != null)
                return false;
        } else if (!codAmortizacion.equals(other.codAmortizacion))
            return false;
        return true;
    }


}
