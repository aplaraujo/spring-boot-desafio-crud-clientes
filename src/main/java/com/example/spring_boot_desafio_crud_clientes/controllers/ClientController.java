package com.example.spring_boot_desafio_crud_clientes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_desafio_crud_clientes.dto.ClientDTO;
import com.example.spring_boot_desafio_crud_clientes.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value="/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        ClientDTO dto = clientService.findById(id);
        return dto;
    }
}
