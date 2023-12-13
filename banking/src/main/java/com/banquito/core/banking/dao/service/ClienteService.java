package com.banquito.core.banking.dao.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.core.banking.dao.ClienteRepository;
import com.banquito.core.banking.dao.TipoRelacionRepository;
import com.banquito.core.banking.domain.Cliente;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final TipoRelacionRepository tipoRelacionRepository;

    public ClienteService(ClienteRepository clienteRepository, TipoRelacionRepository tipoRelacionRepository) {
        this.clienteRepository = clienteRepository;
        this.tipoRelacionRepository = tipoRelacionRepository;
    }

    public Cliente obtainById(Long Id) {
        try {
            Optional<Cliente> opt = this.clienteRepository.findById(Id);
            if (opt.isPresent()) {
                return opt.get();
            } else {

            }
        } catch (Exception e) {

        }
    }

}
