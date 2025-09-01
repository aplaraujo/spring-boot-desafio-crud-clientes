package com.example.spring_boot_desafio_crud_clientes.dto;
import java.time.LocalDate;

import com.example.spring_boot_desafio_crud_clientes.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ClientDTO {
    private Long id;

    @NotBlank(message="Campo requerido")
    @Size(min=3, max=80, message="Nome precisa ter de 3 a 80 caracteres")
    private String name;

    @NotBlank(message="Campo requerido")
    @Size(min=11, max=11, message="CPF precisa ter 11 caracteres")
    private String cpf;

    @Positive(message="O valor da renda deve ser positivo")
    private Double income;

    @PastOrPresent
    private LocalDate birthDate;

    @PositiveOrZero(message="O número de filhos deve ser maior ou igual a zero")
    private Integer children;

    public ClientDTO() {}

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.income = entity.getIncome();
        this.birthDate = entity.getBirthDate();
        this.children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }

}
