package com.banquito.core.banking.domain;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "TASA_INTERES")
public class TasaInteres {

    @Id
    @Column(name = "COD_TASA_INTERES", nullable = false)
    private String codTasaInteres;

    @Column(name = "TIPO_TASA_INTERES", nullable = false)
    private String tipoTasaInteres;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "TASA_MINIMA", nullable = false ,precision = 5, scale = 2)
    private BigDecimal tasaMinima;

    @Column(name = "TASA_MAXIMA", nullable = false, precision =5, scale = 2)
    private BigDecimal tasaMaxima;

    public String getCodTasaInteres() {
        return codTasaInteres;
    }

    public void setCodTasaInteres(String codTasaInteres) {
        this.codTasaInteres = codTasaInteres;
    }

    public String getTipoTasaInteres() {
        return tipoTasaInteres;
    }

    public void setTipoTasaInteres(String tipoTasaInteres) {
        this.tipoTasaInteres = tipoTasaInteres;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getTasaMinima() {
        return tasaMinima;
    }

    public void setTasaMinima(BigDecimal tasaMinima) {
        this.tasaMinima = tasaMinima;
    }

    public BigDecimal getTasaMaxima() {
        return tasaMaxima;
    }

    public void setTasaMaxima(BigDecimal tasaMaxima) {
        this.tasaMaxima = tasaMaxima;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codTasaInteres == null) ? 0 : codTasaInteres.hashCode());
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
        TasaInteres other = (TasaInteres) obj;
        if (codTasaInteres == null) {
            if (other.codTasaInteres != null)
                return false;
        } else if (!codTasaInteres.equals(other.codTasaInteres))
            return false;
        return true;
    }



    
}
