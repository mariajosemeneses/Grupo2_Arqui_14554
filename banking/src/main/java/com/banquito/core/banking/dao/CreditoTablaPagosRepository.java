package com.banquito.core.banking.dao;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.domain.CreditoTablaPagos;

public interface CreditoTablaPagosRepository extends CrudRepository<CreditoTablaPagosRepository, Long> {
    CreditoTablaPagos findbyFechaPlanificadPagoAndEstado(Date fechaPlanificadaPago, String estado);

}
