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

@Entity
@Table(name = "TIPO_CREDITO")
public class TipoCredito {

    @Id
    @Column(name = "COD_TIPO_CREDITO", nullable = false)
    private Long codigo;

    @ManyToOne()
    @JoinColumn(name = "COD_TASA_INTERES")
    private TasaInteres tasaIntereses;

    @OneToMany(mappedBy = "tipoCredito")
    private List<TipoCredito> tipoCredito;
    /*
     * @Column(name = "COD_TASA_INTERES", nullable = false, length = 8)
     * private String codigoTasaInteres;
     */
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "TIPO_CLIENTE", nullable = false, length = 3)
    private String tipoCliente;

    @Column(name = "UNIDAD_PLAZO", nullable = false, length = 3)
    private String unidadPlazo;

    @Column(name = "PLAZO_MINIMO", nullable = false, length = 3)
    private Long plazoMinimo;

    @Column(name = "PLAZO_MAXIMO", nullable = false, length = 3)
    private Long plazoMaximo;

    @Column(name = "MONTO_MINIMO", nullable = false, length = 18, scale = 2)
    private Long montoMinimo;

    @Column(name = "MONTO_MAXIMO", nullable = false, length = 18, scale = 2)
    private Long montoMaximo;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoCambio;

    public TipoCredito() {
    }

    public TipoCredito(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TasaInteres getTasaIntereses() {
        return tasaIntereses;
    }

    public void setTasaIntereses(TasaInteres tasaIntereses) {
        this.tasaIntereses = tasaIntereses;
    }

    public List<TipoCredito> getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(List<TipoCredito> tipoCredito) {
        this.tipoCredito = tipoCredito;
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

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getUnidadPlazo() {
        return unidadPlazo;
    }

    public void setUnidadPlazo(String unidadPlazo) {
        this.unidadPlazo = unidadPlazo;
    }

    public Long getPlazoMinimo() {
        return plazoMinimo;
    }

    public void setPlazoMinimo(Long plazoMinimo) {
        this.plazoMinimo = plazoMinimo;
    }

    public Long getPlazoMaximo() {
        return plazoMaximo;
    }

    public void setPlazoMaximo(Long plazoMaximo) {
        this.plazoMaximo = plazoMaximo;
    }

    public Long getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(Long montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    public Long getMontoMaximo() {
        return montoMaximo;
    }

    public void setMontoMaximo(Long montoMaximo) {
        this.montoMaximo = montoMaximo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaUltimoCambio() {
        return fechaUltimoCambio;
    }

    public void setFechaUltimoCambio(Date fechaUltimoCambio) {
        this.fechaUltimoCambio = fechaUltimoCambio;
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
        TipoCredito other = (TipoCredito) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
