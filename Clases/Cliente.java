package com.banquito.core.banking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @Column(name = "COD_CLIENTE", nullable = false)
    private Long codigoCliente;

    @Column(name = "TIPO_CLIENTE", nullable = false, length = 3)
    private String tipoCliente;

    @Column(name = "TIPO_IDENTIFICACION", nullable = false, length = 3)
    private String tipoIdentificacion;

    @Column(name = "NUMERO_IDENTIFICACION", nullable = false, length = 20)
    private String numeroIdentificacion;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "DIRECCION", length = 200)
    private String direccion;

    @Column(name = "CORREO_ELECTRONICO", length = 100)
    private String correoElectronico;

    @Column(name = "TELEFONO", length = 15)
    private String telefono;

    public Cliente() {
    }

    public Cliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoCliente == null) ? 0 : codigoCliente.hashCode());
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
        Cliente other = (Cliente) obj;
        if (codigoCliente == null) {
            if (other.codigoCliente != null)
                return false;
        } else if (!codigoCliente.equals(other.codigoCliente))
            return false;
        return true;
    }

}
