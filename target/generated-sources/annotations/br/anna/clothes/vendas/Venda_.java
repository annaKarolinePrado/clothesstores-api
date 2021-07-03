package br.anna.clothes.vendas;

import br.anna.clothes.pessoas.Pessoa;
import br.anna.clothes.produtos.Produto;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Venda.class)
public abstract class Venda_ {

	public static volatile SingularAttribute<Venda, Pessoa> cliente;
	public static volatile SingularAttribute<Venda, String> forma_pagamento;
	public static volatile SingularAttribute<Venda, String> observacoes;
	public static volatile SingularAttribute<Venda, Double> total;
	public static volatile SingularAttribute<Venda, Produto> produto;
	public static volatile SingularAttribute<Venda, LocalDate> dt_emissao;
	public static volatile SingularAttribute<Venda, Integer> id;
	public static volatile SingularAttribute<Venda, Pessoa> funcionario;

}

