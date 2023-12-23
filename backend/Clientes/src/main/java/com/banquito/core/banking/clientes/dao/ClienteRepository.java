package com.banquito.core.banking.clientes.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.banquito.core.banking.clientes.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Cliente findByTipoIdentificacionAndNumeroIdentificacion(String tipoIdentificacion, String numeroIdentificacion);

    Cliente findByCorreoElectronico(String correoElectronico);

    List<Cliente> findByTelefonoOrderByCodigo(String telefono);

    List<Cliente> findByTipoClienteAndApellidosLikeOrderByApellidos(String tipoCliente, String apellidos);

    List<Cliente> findByTipoClienteAndRazonSocialLikeOrderByRazonSocial(String tipoCliente, String razonSocial);

}