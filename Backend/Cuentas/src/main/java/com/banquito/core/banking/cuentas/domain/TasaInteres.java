package com.banquito.core.banking.cuentas.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Version;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TASA_INTERES")
public class TasaInteres {

    @Id
    @Column(name = "COD_TASA_INTERES", nullable = false, length = 8)
    private String codigo;

    @OneToMany(mappedBy = "tasaInteres")
    private List<TipoCuenta> tipoCuenta;


    @Column(name = "TIPO_TASA_INTERES", nullable = false, length = 3)
    private String tipo;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "TASA_MINIMA", nullable = false, length = 5, scale = 2)
    private long tasaMinima;

    @Column(name = "TIPO_MAXIMA", nullable = false, length = 5, scale = 2)
    private long tasaMaxima;

    @Version
    private long version;
    public TasaInteres(String codigo) {
        this.codigo = codigo;
    }

    

}

