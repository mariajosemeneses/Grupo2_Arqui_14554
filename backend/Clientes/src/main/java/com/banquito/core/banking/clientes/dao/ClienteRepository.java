package com.banquito.core.banking.clientes.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.banquito.core.banking.clientes.domain.Cliente;
import com.banquito.core.banking.clientes.domain.Cliente.TipoIdentificacion;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Optional<Cliente> findByTipoIdentificacionAndNumeroIdentificacion(TipoIdentificacion tipoIdentificacion, String numeroIdentificacion);

    Optional<Cliente> findByCorreoElectronico(String correoElectronico);

    List<Cliente> findByTelefonoOrderByCodigo(String telefono);

    List<Cliente> findByTipoClienteAndApellidosLikeOrderByApellidos(String tipoCliente, String apellidos);

    List<Cliente> findByTipoClienteAndRazonSocialLikeOrderByRazonSocial(String tipoCliente, String razonSocial);

}