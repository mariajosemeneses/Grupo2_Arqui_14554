package com.banquito.core.banking.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.domain.Credito;

public interface CreditoRepository extends CrudRepository<Credito, Long>{

    Credito findByNumeroOperacion(String numeroOperacion);
    List<Credito> findByCodigoTipoCredito(Integer codigoTipoCredito);
    List<Credito> findByCodigoCliente(Integer codigoCliente);
    List<Credito> findByFechaCreacionBetween(Date startDate, Date endDate);  
    List<Credito> findByPlazoLessThanEqual(long plazo);
    List<Credito> findByEstadoIn(List<String> estados);
    List<Credito> findByFechaDesembolsoBefore(Date fechaDesembolso);
    List<Credito> findByFechaUltimoPagoAfter(Date fechaUltimoPago);
    List<Credito> findByEstadoAndMontoGreaterThan(String estado, long monto);
    List<Credito> findByCapitalPendienteLessThan(long capitalPendiente);
    List<Credito> findByFechaUltimoCambioAfterOrderByFechaUltimoCambioDesc(Date fechaUltimoCambio);


}
