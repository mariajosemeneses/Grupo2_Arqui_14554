package com.banquito.core.banking.clientes.domain;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CLIENTE", nullable = false)
    private Long codigo;

    @Column(name = "TIPO_CLIENTE", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @Column(name = "TIPO_IDENTIFICACION", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "NUMERO_IDENTIFICACION", nullable = false, length = 20)
    private String numeroIdentificacion;

    @Column(name = "APELLIDOS", length = 100)
    private String apellidos;

    @Column(name = "NOMBRES", length = 100)
    private String nombres;

    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "RAZON_SOCIAL", length = 100)
    private String razonSocial;

    @Column(name = "NOMBRE_COMERCIAL", length = 100)
    private String nombreComercial;

    @Column(name = "FECHA_CONSTITUCION")
    @Temporal(TemporalType.DATE)
    private Date fechaConstitucion;

    @Column(name = "DIRECCION", length = 200)
    private String direccion;

    @Column(name = "CORREO_ELECTRONICO", nullable = false, length = 100)
    private String correoElectronico;

    @Column(name = "TELEFONO", length = 15)
    private String telefono;

    @Version
    private Long version;

    public Cliente() {
    }

    public Cliente(Long codigo) {
        this.codigo = codigo;
    }    

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public Date getFechaConstitucion() {
        return fechaConstitucion;
    }

    public void setFechaConstitucion(Date fechaConstitucion) {
        this.fechaConstitucion = fechaConstitucion;
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
        Cliente other = (Cliente) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [codigo=" + codigo + ", tipoCliente=" + tipoCliente + ", tipoIdentificacion="
                + tipoIdentificacion + ", numeroIdentificacion=" + numeroIdentificacion + ", apellidos=" + apellidos
                + ", nombres=" + nombres + ", fechaNacimiento=" + fechaNacimiento + ", razonSocial=" + razonSocial
                + ", nombreComercial=" + nombreComercial + ", fechaConstitucion=" + fechaConstitucion + ", direccion="
                + direccion + ", correoElectronico=" + correoElectronico + ", telefono=" + telefono + "]";
    }

    public enum TipoCliente {
        NAT,
        JUR
    }

    public enum TipoIdentificacion {
        CED,
        PAS,
        RUC
    }
}