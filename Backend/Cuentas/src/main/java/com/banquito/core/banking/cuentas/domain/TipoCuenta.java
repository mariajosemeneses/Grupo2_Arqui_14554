package com.banquito.core.banking.cuentas.domain;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TIPO_CUENTA")
public class TipoCuenta {

    @Id
    @Column(name = "COD_TIPO_CUENTA", nullable = false, length = 10)
    private String codigo;

    @OneToMany(mappedBy = "tipoCuenta")
    private List<Cuenta> cuenta;

    @ManyToOne()
    @JoinColumn(name = "COD_TASA_INTERES")
    private TasaInteres tasaIntereses;

    @Column(name = "COD_TASA_INTERES", nullable = false, length = 8)
    private String codigoTasaInteres;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "TIPO_CAPITALIZACION", nullable = false, length = 3)
    private String tipoCapitalizacion;

    @Column(name = "FORMA_CAPITALIZACION", nullable = false, length = 3)
    private String formaCapitalizacion;

    @Column(name = "MAXIMO_NUMERO_INTERVINIENTES", nullable = false, length = 2)
    private String MaximoNumeroIntervinientes;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaCreacion;

    public TipoCuenta(String codigo) {
        this.codigo = codigo;
    }

    

}
