package com.banquito.core.banking.dao;
import org.springframework.data.repository.CrudRepository;
import com.banquito.core.banking.domain.TasaInteres;

public interface TasaInteresRepository extends CrudRepository<TasaInteresRepository, Long> {
TasaInteres findbyTipoTasaInteres(String tipo);
}
