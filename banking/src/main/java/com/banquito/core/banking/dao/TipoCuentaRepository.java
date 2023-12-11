package com.banquito.core.banking.dao;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.domain.TipoCuenta;

public interface TipoCuentaRepository extends CrudRepository<TipoCuenta, String> {

    TipoCuenta findByNombre(String nombre);

}