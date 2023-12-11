package com.banquito.core.banking.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CLIENTE", nullable = false)
    private Long codigo;

    @Column(name = "TIPO_CLIENTE", nullable = false, length = 3)
    private String tipoCliente;

    @Column(name = "TIPO_IDENTIFICACION", nullable = false, length = 3)
    private String tipoIdentificacion;

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

    @OneToMany(mappedBy = "clienteEmpresa")
    private List<ClientePersonaRelacion> ClientePersonaRelacionEmpresa;

    @OneToMany(mappedBy = "clientePersona")
    private List<ClientePersonaRelacion> ClientePersonaRelacionPersona;

    @OneToMany(mappedBy = "cliente")
    private List<CreditoInterviniente> creditoInterviniente;

    @OneToMany(mappedBy = "cliente")
    private List<Credito> credito;

    @OneToMany(mappedBy = "cliente")
    private List<Cuenta> cuenta;

    @OneToMany(mappedBy = "cliente")
    private List<CuentaIntervinientes> cuentaIntervinientes;

    public Cliente(Long codigo) {
        this.codigo = codigo;
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
                + direccion + ", correoElectronico=" + correoElectronico + ", telefono=" + telefono
                + ", ClientePersonaRelacionEmpresa=" + ClientePersonaRelacionEmpresa
                + ", ClientePersonaRelacionPersona=" + ClientePersonaRelacionPersona + ", creditoInterviniente="
                + creditoInterviniente + ", credito=" + credito + ", cuenta=" + cuenta + ", cuentaIntervinientes="
                + cuentaIntervinientes + "]";
    }

    @Version long version;

}
