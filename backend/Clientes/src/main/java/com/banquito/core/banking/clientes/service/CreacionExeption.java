package com.banquito.core.banking.clientes.service;

public class CreacionExeption extends RuntimeException {

    public CreacionExeption(String message) {
        super(message);
    }

    public CreacionExeption(String message, Exception cause) {
        super(message, cause);
    }
}
