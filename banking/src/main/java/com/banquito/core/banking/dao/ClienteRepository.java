package com.banquito.core.banking.dao;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.domain.Cliente;
import java.util.List;


public interface ClienteRepository extends CrudRepository<Cliente, Long>{

    Cliente findfindByTipoIdentificacionAndNumeroIdentificacion (String tipoIdentificacion, String numeroIdentificacion);
    Cliente findfindByCorreoElectronico(String correoElectronico);
    List <Cliente> findByTelefono(String telefono);
    

    


}
