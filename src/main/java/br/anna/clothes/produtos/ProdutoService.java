/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.anna.clothes.produtos;

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
@Path("produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoService {
    
    @PersistenceContext(unitName = "ClothesPU")
    private EntityManager entityManager;
    
    @GET
    public List<Produto> getProdutos() {
        Query query = entityManager.createQuery("SELECT p FROM Produto p");
        return query.getResultList();
    }

    @POST
    public Produto adicionar(Produto produto) {
        entityManager.persist(produto);
        return produto;
    }

    @PUT
    @Path("{id}")
    public Produto atualizar(@PathParam("id") Integer id, Produto produtoAtualizado) {
        Produto produtoEncontrado = getProduto(id);
        produtoEncontrado.setDescricao(produtoAtualizado.getDescricao());
        produtoEncontrado.setPreco(produtoAtualizado.getPreco());
        entityManager.merge(produtoEncontrado);
        return produtoEncontrado;
    }

    @DELETE
    @Path("{id}")
    public Produto excluir(@PathParam("id") Integer id) {
        Produto produto = getProduto(id);
        entityManager.remove(produto);
        return produto;
    }
    
    @GET
    @Path("{id}")
    public Produto getProduto(@PathParam("id") Integer id) {
        return entityManager.find(Produto.class, id);
    }
}