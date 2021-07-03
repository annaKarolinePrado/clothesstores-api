/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.anna.clothes.pessoas;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pessoas", schema = "public")
public class Pessoa {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Size(min = 3, message = "O campo nome precisa ter no mínimo 3 caracteres")
    @NotNull(message = "O campo nome não pode ser nulo")
    private String nome;
    
    @Size(min = 7, message = "O campo cpf precisa ter no mínimo 7 caracteres")
    @NotNull(message = "O campo cpf não pode ser nulo")
    private String cpf;
    
    //@NotNull(message = "O campo cpf não pode ser nulo")
    @Column( name = "dt_nascimento")
    private LocalDate  dt_nascimento; 
    
    @NotNull(message = "O campo tipo não pode ser nulo")
    private String tipo;
    
    private String telefone;
    
    private String email;

     public Pessoa(){}
     
    public Pessoa(Integer id, String nome, String cpf, LocalDate dt_nascimento, String tipo, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
        this.tipo = tipo;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
}
