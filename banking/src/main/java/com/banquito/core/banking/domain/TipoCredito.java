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
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TIPO_CREDITO")
public class TipoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Version
    private long version;

    public TipoCredito(Long codigo) {
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
        TipoCredito other = (TipoCredito) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
