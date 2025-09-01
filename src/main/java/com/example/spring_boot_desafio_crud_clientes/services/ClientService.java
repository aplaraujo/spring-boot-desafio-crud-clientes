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
import com.example.spring_boot_desafio_crud_clientes.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly=true)
    public ClientDTO findById(Long id) {
        Optional<Client> result = clientRepository.findById(id);
        Client client = result.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
        ClientDTO dto = new ClientDTO(client);
        return dto;
    }

    @Transactional(readOnly=true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(client -> new ClientDTO(client));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Client entity = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente com o id: " + id + " não encontrado"));
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }


    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
