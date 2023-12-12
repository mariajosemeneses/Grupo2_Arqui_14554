package com.banquito.core.banking.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.domain.Cliente;
import com.banquito.core.banking.domain.ClientePersonaRelacion;

public interface ClientePersonaRelacionRepository extends CrudRepository<ClientePersonaRelacion, Long> {

    List<ClientePersonaRelacion> findByClienteEmpresaandEstado(Cliente clienteEmpresa, String estado);

    List<ClientePersonaRelacion> findByClientePersonaAndEstado(Cliente clientePersona, String estado);

}