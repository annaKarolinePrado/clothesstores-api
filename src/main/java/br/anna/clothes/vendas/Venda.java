/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.anna.clothes.vendas;

import br.anna.clothes.pessoas.Pessoa;
import br.anna.clothes.produtos.Produto;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vendas", schema = "public")
public class Venda  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Pessoa cliente;
    
    @ManyToOne
    @JoinColumn(name="funcionario_id")
    private Pessoa funcionario;    
    
    private Double total;  
    
    @Column( name = "forma_pagamento")
    private String forma_pagamento;;
    
    private String observacoes;
    
    @Column( name = "dt_emissao")
    private LocalDate  dt_emissao;
    
    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    public Venda() {
    }

    public Venda(Integer id, Pessoa cliente, Pessoa funcionario, Double total, String forma_pagamento, String observacoes, LocalDate dt_emissao) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.total = total;
        this.forma_pagamento = forma_pagamento;
        this.observacoes = observacoes;
        this.dt_emissao = dt_emissao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Pessoa getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getDt_emissao() {
        return dt_emissao;
    }

    public void setDt_emissao(LocalDate dt_emissao) {
        this.dt_emissao = dt_emissao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}