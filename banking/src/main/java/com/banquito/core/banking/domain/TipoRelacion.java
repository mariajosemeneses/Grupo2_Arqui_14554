package com.banquito.core.banking.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_RELACION")
public class TipoRelacion {

    @Id
    @Column(name = "COD_TIPO_RELACION", nullable = false, length = 3)
    private String codigo;

    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;

    @OneToMany(mappedBy = "tipoRelacion")
    private List<ClientePersonaRelacion> clientePersonaRelacion;

    public TipoRelacion() {
    }

    public TipoRelacion(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ClientePersonaRelacion> getClientePersonaRelacion() {
        return clientePersonaRelacion;
    }

    public void setClientePersonaRelacion(List<ClientePersonaRelacion> clientePersonaRelacion) {
        this.clientePersonaRelacion = clientePersonaRelacion;
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
        TipoRelacion other = (TipoRelacion) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
