package com.banquito.core.banking.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TASA_INTERES")
public class TasaInteres {

    @Id
    @Column(name = "COD_TASA_INTERES", nullable = false, length = 8)
    private String codigo;

    @OneToMany(mappedBy = "tasaInteres")
    private List<TipoCuenta> tipoCuenta;

    @OneToMany(mappedBy = "tasaInteres")
    private List<TipoCredito> tipoCredito;

    @Column(name = "TIPO_TASA_INTERES", nullable = false, length = 3)
    private String tipo;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "TASA_MINIMA", nullable = false, length = 5, scale = 2)
    private Long tasaMinima;

    @Column(name = "TIPO_MAXIMA", nullable = false, length = 5, scale = 2)
    private Long tasaMaxima;

    public TasaInteres() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<TipoCuenta> getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(List<TipoCuenta> tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public List<TipoCredito> getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(List<TipoCredito> tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTasaMinima() {
        return tasaMinima;
    }

    public void setTasaMinima(Long tasaMinima) {
        this.tasaMinima = tasaMinima;
    }

    public Long getTasaMaxima() {
        return tasaMaxima;
    }

    public void setTasaMaxima(Long tasaMaxima) {
        this.tasaMaxima = tasaMaxima;
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
        TasaInteres other = (TasaInteres) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
