package com.example.spring_boot_desafio_crud_clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot_desafio_crud_clientes.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
