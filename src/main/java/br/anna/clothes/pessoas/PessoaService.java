/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.anna.clothes.pessoas;

import br.anna.clothes.pessoas.*;
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
@Path("pessoas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaService {
    
    @PersistenceContext(unitName = "ClothesPU")
    private EntityManager entityManager;
    
    @GET
    public List<Pessoa> getPessoas() {
        Query query = entityManager.createQuery("SELECT p FROM Pessoa p");
        return query.getResultList();
    }

    @POST
    public Pessoa adicionar(Pessoa pessoa) {
        entityManager.persist(pessoa);
        return pessoa;
    }

    @PUT
    @Path("{id}")
    public Pessoa atualizar(@PathParam("id") Integer id, Pessoa pessoaAtualizado) {
        Pessoa pessoaEncontrado = getPessoa(id);
        pessoaEncontrado.setCpf(pessoaAtualizado.getCpf());
        pessoaEncontrado.setDt_nascimento(pessoaAtualizado.getDt_nascimento());
        pessoaEncontrado.setEmail(pessoaAtualizado.getEmail());
        pessoaEncontrado.setNome(pessoaAtualizado.getNome());
        pessoaEncontrado.setTipo(pessoaAtualizado.getTipo());
        entityManager.merge(pessoaEncontrado);
        return pessoaEncontrado;
    }

    @DELETE
    @Path("{id}")
    public Pessoa excluir(@PathParam("id") Integer id) {
        Pessoa pessoa = getPessoa(id);
        entityManager.remove(pessoa);
        return pessoa;
    }
    
    @GET
    @Path("{id}")
    public Pessoa getPessoa(@PathParam("id") Integer id) {
        return entityManager.find(Pessoa.class, id);
    }
}