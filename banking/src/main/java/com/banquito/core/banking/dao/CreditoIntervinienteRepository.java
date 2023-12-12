package com.banquito.core.banking.dao;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.domain.CreditoInterviniente;
import com.banquito.core.banking.domain.CreditoIntervinientePK;

public interface CreditoIntervinienteRepository extends CrudRepository<CreditoInterviniente, CreditoIntervinientePK> {

}
