package com.example.spring_boot_desafio_crud_clientes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_boot_desafio_crud_clientes.dto.ClientDTO;
import com.example.spring_boot_desafio_crud_clientes.entities.Client;
import com.example.spring_boot_desafio_crud_clientes.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly=true)
    public ClientDTO findById(Long id) {
        Optional<Client> result = clientRepository.findById(id);
        Client client = result.get();
        ClientDTO dto = new ClientDTO(client);
        return dto;
    }

    @Transactional(readOnly=true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(client -> new ClientDTO(client));
    }
}
