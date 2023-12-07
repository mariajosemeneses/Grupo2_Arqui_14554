package com.banquito.core.banking.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "CREDITO")
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CREDITO", nullable = false)
    private Long codigo;

    @ManyToOne()
    @JoinColumn(name = "COD_TIPO_CREDITO")
    private TipoCredito TipoCredito;

    @ManyToOne()
    @JoinColumn(name = "COD_CLIENTE")
    private Cliente Cliente;

    @OneToMany(mappedBy = "credito")
    private List<CreditoInterviniente> creditoInterviniente;

    @OneToMany(mappedBy = "credito")
    private List<CreditoTablaPagos> creditoTablaPagos;

    @Column(name = "COD_TIPO_CREDITO", nullable = false)
    private Integer codigoTipoCredito;

    @Column(name = "COD_CLIENTE", nullable = false)
    private Integer codigoCliente;

    @Column(name = "NUMERO_OPERACION", nullable = false, length = 8)
    private String numeroOperacion;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreación;

    @Column(name = "MONTO", nullable = false, length = 18, scale = 2)
    private long monto;

    @Column(name = "PLAZO", nullable = false, length = 3)
    private long plazo;

    @Column(name = "TASA_INTERES", nullable = false, length = 5, scale = 2)
    private long tazaInteres;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    @Column(name = "FECHA_DESEMBOLSO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesembolso;

    @Column(name = "FECHA_ULTIMO_PAGO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaUltimoPago;

    @Column(name = "CAPITAL_PENDIENTE", nullable = false, length = 18, scale = 2)
    private long capitalPendiente;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoCambio;

    public Credito() {
    }

    public Credito(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoCredito getTipoCredito() {
        return TipoCredito;
    }

    public void setTipoCredito(TipoCredito tipoCredito) {
        TipoCredito = tipoCredito;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
    }

    public List<CreditoInterviniente> getCreditoInterviniente() {
        return creditoInterviniente;
    }

    public void setCreditoInterviniente(List<CreditoInterviniente> creditoInterviniente) {
        this.creditoInterviniente = creditoInterviniente;
    }

    public List<CreditoTablaPagos> getCreditoTablaPagos() {
        return creditoTablaPagos;
    }

    public void setCreditoTablaPagos(List<CreditoTablaPagos> creditoTablaPagos) {
        this.creditoTablaPagos = creditoTablaPagos;
    }

    public Integer getCodigoTipoCredito() {
        return codigoTipoCredito;
    }

    public void setCodigoTipoCredito(Integer codigoTipoCredito) {
        this.codigoTipoCredito = codigoTipoCredito;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public Date getFechaCreación() {
        return fechaCreación;
    }

    public void setFechaCreación(Date fechaCreación) {
        this.fechaCreación = fechaCreación;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public long getPlazo() {
        return plazo;
    }

    public void setPlazo(long plazo) {
        this.plazo = plazo;
    }

    public long getTazaInteres() {
        return tazaInteres;
    }

    public void setTazaInteres(long tazaInteres) {
        this.tazaInteres = tazaInteres;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(Date fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public Date getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    public void setFechaUltimoPago(Date fechaUltimoPago) {
        this.fechaUltimoPago = fechaUltimoPago;
    }

    public long getCapitalPendiente() {
        return capitalPendiente;
    }

    public void setCapitalPendiente(long capitalPendiente) {
        this.capitalPendiente = capitalPendiente;
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
        Credito other = (Credito) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
