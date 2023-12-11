package com.banquito.core.banking.dao;
import java.util.List;

import com.banquito.core.banking.domain.Cliente;
import com.banquito.core.banking.domain.ClientePersonaRelacion;

public interface CreditoIntervinienteRepository {


    List<ClientePersonaRelacion> findByClienteEmpresa(Cliente clienteEmpresa);
    List<ClientePersonaRelacion> findByClientePersona(Cliente clientePersona);
    List<ClientePersonaRelacion> findByEstado(String estado);
}
