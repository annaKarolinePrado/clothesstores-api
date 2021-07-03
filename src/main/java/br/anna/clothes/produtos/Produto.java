/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.anna.clothes.produtos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produtos", schema = "public")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Size(min = 3, message = "O campo descrição precisa ter no mínimo 3 caracteres")
    @NotNull(message = "O campo descrição não pode ser nulo")
    private String descricao;
    
    @NotNull(message = "O campo preço não pode ser nulo")
    @Min(value = 0, message = "O campo preço não pode ser negativo")
    private Double preco; 
    
    @NotNull(message = "O campo tipo não pode ser nulo")
    private String tipo;
    
    @NotNull(message = "O campo status não pode ser nulo")
    private String status;
    
    public Produto() {
    }

    public Produto(Integer id, String descricao, Double preco, String tipo,String status) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }
 
      public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
      
}