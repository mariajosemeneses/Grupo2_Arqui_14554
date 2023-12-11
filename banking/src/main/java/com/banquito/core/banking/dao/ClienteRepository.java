package com.banquito.core.banking.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.banquito.core.banking.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Cliente findByTipoIdentificacionAndNumeroIdentificacion(String tipoIdentificacion, String numeroIdentificacion);
    Cliente findByCorreoElectronico(String correoElectronico);
    List<Cliente> findByTelefono(String telefono);
}
