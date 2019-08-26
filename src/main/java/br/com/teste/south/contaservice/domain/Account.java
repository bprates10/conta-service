package br.com.teste.south.contaservice.domain;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Document
public class Account {
    @Id
    private String id;
    @Pattern(regexp = "[\\d]{6}", message = "Apenas numeros e o campo deve conter 6 digitos.")
    private String numero;
    @Pattern(regexp = "[\\d]{4}", message = "Apenas numeros e o campo deve conter 4 digitos.")
    private String agencia;
    @CPF(message = "CPF deve conter dígitos válidos")
    private String cpf;
    private boolean status;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
