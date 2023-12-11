package com.banquito.core.banking.dao;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.domain.TipoCredito;

public interface TipoCreditoRepository extends CrudRepository<TipoCredito, Long> {

    TipoCredito findByNombre(String nombre);

}