package com.banquito.core.banking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity

@Table(name = "CREDITO_TRANSACCION")
public class CreditoTransaccion {
 @Id
 @Column(name = "COD_CREDITO_TRANSACCION_SERIAL", nullable = false)
    private Long codCreditoTransaccionSerial;
    @Column(name = "COD_CREDITO")
    private Long codCredito;
    @Column(name = "MONTO_PRINCIPAL", nullable = false, precision = 18, scale = 2)
    private BigDecimal montoPrincipal;
    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(name = "METODO_PAGO", nullable = false, length = 4)
    private String metodoPago;
    @Column(name = "MONTO_INTERES", nullable = false, precision = 18, scale = 2)
    private BigDecimal montoInteres;
      @Column(name = "MONTO_TOTAL", nullable = false, precision = 18, scale = 2)
    private BigDecimal montoTotal;
    public Long getCodCreditoTransaccionSerial() {
        return codCreditoTransaccionSerial;
    }
    public void setCodCreditoTransaccionSerial(Long codCreditoTransaccionSerial) {
        this.codCreditoTransaccionSerial = codCreditoTransaccionSerial;
    }
    public Long getCodCredito() {
        return codCredito;
    }
    public void setCodCredito(Long codCredito) {
        this.codCredito = codCredito;
    }
    public BigDecimal getMontoPrincipal() {
        return montoPrincipal;
    }
    public void setMontoPrincipal(BigDecimal montoPrincipal) {
        this.montoPrincipal = montoPrincipal;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    public BigDecimal getMontoInteres() {
        return montoInteres;
    }
    public void setMontoInteres(BigDecimal montoInteres) {
        this.montoInteres = montoInteres;
    }
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCreditoTransaccionSerial == null) ? 0 : codCreditoTransaccionSerial.hashCode());
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
        CreditoTransaccion other = (CreditoTransaccion) obj;
        if (codCreditoTransaccionSerial == null) {
            if (other.codCreditoTransaccionSerial != null)
                return false;
        } else if (!codCreditoTransaccionSerial.equals(other.codCreditoTransaccionSerial))
            return false;
        return true;
    }




}
