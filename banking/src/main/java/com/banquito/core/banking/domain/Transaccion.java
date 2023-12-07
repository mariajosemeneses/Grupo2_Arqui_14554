package com.banquito.core.banking.domain;

import java.math.BigDecimal;
import java.sql.Date;

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
    private BigDecimal valorDebe;

    @Column(name = "VALOR_HABER", nullable = false, precision = 18, scale = 2)
    private BigDecimal valorHaber;

    @Column(name = "TIPO_TRANSACCION", nullable = false, length = 8)
    private String tipoTransaccion;

    @Column(name = "DETALLE", nullable = false, length = 50)
    private String detalle;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "FECHA_AFECTACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAfectacion;

    public Transaccion() {
    }

    public Transaccion(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getTipoAfectacion() {
        return tipoAfectacion;
    }

    public void setTipoAfectacion(String tipoAfectacion) {
        this.tipoAfectacion = tipoAfectacion;
    }

    public BigDecimal getValorDebe() {
        return valorDebe;
    }

    public void setValorDebe(BigDecimal valorDebe) {
        this.valorDebe = valorDebe;
    }

    public BigDecimal getValorHaber() {
        return valorHaber;
    }

    public void setValorHaber(BigDecimal valorHaber) {
        this.valorHaber = valorHaber;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAfectacion() {
        return fechaAfectacion;
    }

    public void setFechaAfectacion(Date fechaAfectacion) {
        this.fechaAfectacion = fechaAfectacion;
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
        Transaccion other = (Transaccion) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
