package com.banquito.core.banking.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TIPO_CUENTA")
public class TipoCuenta {

    @Id
    @Column(name = "COD_TIPO_CUENTA", nullable = false, length = 10)
    private String codigo;

    @OneToMany(mappedBy = "tipoCuenta")
    private List<Cuenta> cuenta;

    @ManyToOne()
    @JoinColumn(name = "COD_TASA_INTERES")
    private TasaInteres tasaIntereses;

    @Column(name = "COD_TASA_INTERES", nullable = false, length = 8)
    private String codigoTasaInteres;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "TIPO_CAPITALIZACION", nullable = false, length = 3)
    private String tipoCapitalizacion;

    @Column(name = "FORMA_CAPITALIZACION", nullable = false, length = 3)
    private String formaCapitalizacion;

    @Column(name = "MAXIMO_NUMERO_INTERVINIENTES", nullable = false, length = 2)
    private String MaximoNumeroIntervinientes;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    public TipoCuenta(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(List<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }

    public TasaInteres getTasaIntereses() {
        return tasaIntereses;
    }

    public void setTasaIntereses(TasaInteres tasaIntereses) {
        this.tasaIntereses = tasaIntereses;
    }

    public String getCodigoTasaInteres() {
        return codigoTasaInteres;
    }

    public void setCodigoTasaInteres(String codigoTasaInteres) {
        this.codigoTasaInteres = codigoTasaInteres;
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

    public String getMaximoNumeroIntervinientes() {
        return MaximoNumeroIntervinientes;
    }

    public void setMaximoNumeroIntervinientes(String maximoNumeroIntervinientes) {
        MaximoNumeroIntervinientes = maximoNumeroIntervinientes;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
        TipoCuenta other = (TipoCuenta) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
