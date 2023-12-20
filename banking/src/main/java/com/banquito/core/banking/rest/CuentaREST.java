package com.banquito.core.banking.rest;

import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.banking.dao.ClienteRepository;
import com.banquito.core.banking.dao.service.CuentaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/Cuenta/")
public class CuentaREST {

    private CuentaService cuentaService;

    @GetMapping
    private ResponseEntity<Iterable<ClienteRepository>> getAllCuentas(){
        return ResponseEntity.ok(cuentaService.findAll());
    }

}
