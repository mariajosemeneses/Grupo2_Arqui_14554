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
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
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

   
    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    public ClientePersonaRelacion(long codigo) {
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
        ClientePersonaRelacion other = (ClientePersonaRelacion) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClientePersonaRelacion [codigo=" + codigo + ", tipoRelacion=" + tipoRelacion + ", clienteEmpresa="
                + clienteEmpresa + ", clientePersona=" + clientePersona + ", estado=" + estado + ", fechaInicio="
                + fechaInicio + ", fechaFin=" + fechaFin + "]";
    }

    @Version long version;
}
