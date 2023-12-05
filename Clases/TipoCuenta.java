package com.banquito.core.banking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_CUENTA")
public class TipoCuenta {
    @Id
 @Column(name = "COD_TIPO_CUENTA", nullable = false,length = 10)
    private String codTipoCuenta;
    @Column(name = "COD_TASA_INTERES", nullable = false,length =8 )
    private String codTasaInteres;
    @Column(name = "NOMBRE", nullable = false,length = 50)
    private String nombre;
    @Column(name = "DESCRIPCION", nullable = false,length = 500)
    private String descripcion;
    @Column(name = "TIPO_CAPITALIZACION", nullable = false,length = 3)
    private String tipoCapitalizacion;
    @Column(name = "FORMA_CAPITALIZACION", nullable = false,length = 3)
    private String formaCapitalizacion;
    @Column(name = "MAXIMO_NUMERO_INTERVINIENTES", nullable = false,precision = 2, scale = 0)
    private BigDecimal maximoNumeroIntervinientes;
    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;
    public String getCodTipoCuenta() {
        return codTipoCuenta;
    }
    public void setCodTipoCuenta(String codTipoCuenta) {
        this.codTipoCuenta = codTipoCuenta;
    }
    public String getCodTasaInteres() {
        return codTasaInteres;
    }
    public void setCodTasaInteres(String codTasaInteres) {
        this.codTasaInteres = codTasaInteres;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTipoCapitalizacion() {
        return tipoCapitalizacion;
    }
    public void setTipoCapitalizacion(String tipoCapitalizacion) {
        this.tipoCapitalizacion = tipoCapitalizacion;
    }
    public String getFormaCapitalizacion() {
        return formaCapitalizacion;
    }
    public void setFormaCapitalizacion(String formaCapitalizacion) {
        this.formaCapitalizacion = formaCapitalizacion;
    }
    public BigDecimal getMaximoNumeroIntervinientes() {
        return maximoNumeroIntervinientes;
    }
    public void setMaximoNumeroIntervinientes(BigDecimal maximoNumeroIntervinientes) {
        this.maximoNumeroIntervinientes = maximoNumeroIntervinientes;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codTipoCuenta == null) ? 0 : codTipoCuenta.hashCode());
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
        TipoCuenta other = (TipoCuenta) obj;
        if (codTipoCuenta == null) {
            if (other.codTipoCuenta != null)
                return false;
        } else if (!codTipoCuenta.equals(other.codTipoCuenta))
            return false;
        return true;
    }


}
