package com.banquito.core.banking.dao;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.domain.Cuenta;

public interface CuentaRepository extends CrudRepository<ClienteRepository, Long>{
    Cuenta findbyTipoCuentaAndNumeroCuenta(String tipoCuenta, String numeroCuenta);
}
