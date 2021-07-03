/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.anna.clothes.vendas;

import br.anna.clothes.vendas.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("vendas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VendaService {
    
    @PersistenceContext(unitName = "ClothesPU")
    private EntityManager entityManager;
    
    @GET
    public List<Venda> getVendas() {
        Query query = entityManager.createQuery("SELECT p FROM Venda p");
        return query.getResultList();
    }

    @POST
    public Venda adicionar(Venda venda) {
        entityManager.persist(venda);
        return venda;
    }

    @PUT
    @Path("{id}")
    public Venda atualizar(@PathParam("id") Integer id, Venda vendaAtualizado) {
        Venda vendaEncontrado = getVenda(id);
        vendaEncontrado.setCliente(vendaAtualizado.getCliente());
        vendaEncontrado.setFuncionario(vendaAtualizado.getFuncionario());
        vendaEncontrado.setForma_pagamento(vendaAtualizado.getForma_pagamento());
        vendaEncontrado.setObservacoes(vendaAtualizado.getObservacoes());
        vendaEncontrado.setProduto(vendaAtualizado.getProduto());
        vendaEncontrado.setTotal(vendaAtualizado.getTotal());
        entityManager.merge(vendaEncontrado);
        return vendaEncontrado;
    }

    @DELETE
    @Path("{id}")
    public Venda excluir(@PathParam("id") Integer id) {
        Venda venda = getVenda(id);
        entityManager.remove(venda);
        return venda;
    }
    
    @GET
    @Path("{id}")
    public Venda getVenda(@PathParam("id") Integer id) {
        return entityManager.find(Venda.class, id);
    }
}