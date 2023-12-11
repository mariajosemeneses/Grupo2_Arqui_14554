package com.banquito.core.banking.dao;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.domain.Transaccion;

public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {
    
    Transaccion findByCodUnico(String codUnico);

}