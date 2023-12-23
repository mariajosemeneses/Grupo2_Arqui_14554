package com.banquito.core.banking.clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.core.banking.clientes.dao.ClienteRepository;
import com.banquito.core.banking.clientes.dao.TipoRelacionRepository;
import com.banquito.core.banking.clientes.domain.Cliente;
import com.banquito.core.banking.clientes.domain.Cliente.TipoCliente;
import com.banquito.core.banking.clientes.domain.Cliente.TipoIdentificacion;
import com.banquito.core.banking.clientes.domain.TipoRelacion;

@Service
public class ClienteService {

    public static final String TIPO_CLIENTE_PERSONA = "NAT";
    private final ClienteRepository clienteRepository;
    private final TipoRelacionRepository tipoRelacionRepository;

    public ClienteService(ClienteRepository clienteRepository, TipoRelacionRepository tipoRelacionRepository) {
        this.clienteRepository = clienteRepository;
        this.tipoRelacionRepository = tipoRelacionRepository;
    }

    public Iterable<Cliente> listAll() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> obtainById(Long id) {
        return this.clienteRepository.findById(id);
    }

    public Iterable<TipoRelacion> listAllTipoRelacion() {
        return this.tipoRelacionRepository.findAll();
    }

    public class ClienteNoEncontradoException extends RuntimeException {
        public ClienteNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }

    public TipoRelacion crearTipoRelacion(TipoRelacion tipoRelacion) {
        try {
            return this.tipoRelacionRepository.save(tipoRelacion);
        } catch (Exception e) {
            throw new CreacionExeption(
                    "Ocurrio un error al crear el TipoRelacion: " + tipoRelacion + " error: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Cliente crearPersona(Cliente cliente) {
        try {            
            if (TipoCliente.NAT.name().equals(cliente.getTipoCliente().name())) {
                if (!TipoIdentificacion.RUC.name().equals(cliente.getTipoIdentificacion().name())) {
                    return this.clienteRepository.save(cliente);
                } else {
                    throw new RuntimeException("El tipo de identificacion es incorrecto para persona");
                }
            } else {
                throw new RuntimeException("El tipo de cliente es invalido");
            }
        } catch (Exception e) {
            throw new CreacionExeption("Error en creacion de Cliente tipo persona: " + cliente + " el error es: " + e);
        }
    }

    public List<Cliente> obtenerPersonaPorApellidos(String apellidos) {
        return this.clienteRepository.findByTipoClienteAndApellidosLikeOrderByApellidos(TIPO_CLIENTE_PERSONA,
                apellidos);
    }
}
