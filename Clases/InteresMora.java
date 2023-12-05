package com.banquito.core.banking.domain;

import java.math.BigDecimal;

import jakarta.persistence.*;


@Entity

@Table(name = "Interes_Mora")
public class InteresMora {
 @Id
    @Column(name = "COD_INTERES_MORA", nullable = false)
    private Long codigo;
    @Column(name = "COD_CREDITO")
    private Long codCredito;
    @Column(name = "MONTO", nullable = false, precision = 18, scale = 2)
    private BigDecimal monto;
    @Column(name = "DIAS_MOROSOS", nullable = false, precision = 3,scale = 0)
    private int diasMorosos;
    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;
    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public Long getCodCredito() {
        return codCredito;
    }
    public void setCodCredito(Long codCredito) {
        this.codCredito = codCredito;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public int getDiasMorosos() {
        return diasMorosos;
    }
    public void setDiasMorosos(int diasMorosos) {
        this.diasMorosos = diasMorosos;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        InteresMora other = (InteresMora) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }





}
