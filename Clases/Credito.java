package com.banquito.core.banking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "CREDITO")
public class Credito {

    @Id
    @Column(name = "COD_CREDITO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCredito;

    @Column(name = "COD_TASA_INTERES")
    private String codTasaInteres;

    @Column(name = "COD_CUENTA", nullable = false)
    private Long codCuenta;

    @Column(name = "TIPO_CREDITO", nullable = false)
    private String tipoCredito;

    @Column(name = "PLAZO", nullable = false)
    private Integer plazo;

    @Column(name = "MONTO", nullable = false)
    private BigDecimal monto;

    @Column(name = "SALDO_PENDIENTE", nullable = false)
    private BigDecimal saldoPendiente;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "FECHA_APROBACION")
    private LocalDateTime fechaAprobacion;

    @Column(name = "FECHA_FINALIZACION", nullable = false)
    private LocalDateTime fechaFinalizacion;

    @Column(name = "ULTIMA_FECHA_MODIFICACION")
    private LocalDateTime ultimaFechaModificacion;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "INTERES_TOTAL")
    private BigDecimal interesTotal;

    public Long getCodCredito() {
        return codCredito;
    }

    public void setCodCredito(Long codCredito) {
        this.codCredito = codCredito;
    }

    public String getCodTasaInteres() {
        return codTasaInteres;
    }

    public void setCodTasaInteres(String codTasaInteres) {
        this.codTasaInteres = codTasaInteres;
    }

    public Long getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(Long codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(BigDecimal saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(LocalDateTime fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public LocalDateTime getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public LocalDateTime getUltimaFechaModificacion() {
        return ultimaFechaModificacion;
    }

    public void setUltimaFechaModificacion(LocalDateTime ultimaFechaModificacion) {
        this.ultimaFechaModificacion = ultimaFechaModificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getInteresTotal() {
        return interesTotal;
    }

    public void setInteresTotal(BigDecimal interesTotal) {
        this.interesTotal = interesTotal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCredito == null) ? 0 : codCredito.hashCode());
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
        Credito other = (Credito) obj;
        if (codCredito == null) {
            if (other.codCredito != null)
                return false;
        } else if (!codCredito.equals(other.codCredito))
            return false;
        return true;
    }

    
}