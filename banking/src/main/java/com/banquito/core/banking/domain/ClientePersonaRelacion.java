package com.banquito.core.banking.domain;

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
@Table(name = "CLIENTE_PERSONA_RELACION")
public class ClientePersonaRelacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CLIENTE_PERSONA_RELACION")
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "CODIGO_TIPO_RELACION")
    private TipoRelacion tipoRelacion;

    @ManyToOne
    @JoinColumn(name = "CODIGO_CLIENTE_EMPRESA")
    private Cliente clienteEmpresa;

    @ManyToOne
    @JoinColumn(name = "CODIGO_CLIENTE_PERSONA")
    private Cliente clientePersona;

    /*
     * OPCIONAL
     * 
     * @Column(name = "COD_TIPO_RELACION", length = 3)
     * private String codigoTipoRelacion;
     * 
     * @Column(name = "COD_CLIENTE_EMPRESA")
     * private Long codigoClienteEmpresa;
     * 
     * @Column(name = "COD_CLIENTE_PERSONA")
     * private Long codigoClientePersona;
     */

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    public ClientePersonaRelacion() {

    }

    public ClientePersonaRelacion(long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoRelacion getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(TipoRelacion tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    public Cliente getClienteEmpresa() {
        return clienteEmpresa;
    }

    public void setClienteEmpresa(Cliente clienteEmpresa) {
        this.clienteEmpresa = clienteEmpresa;
    }

    public Cliente getClientePersona() {
        return clientePersona;
    }

    public void setClientePersona(Cliente clientePersona) {
        this.clientePersona = clientePersona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
        ClientePersonaRelacion other = (ClientePersonaRelacion) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
