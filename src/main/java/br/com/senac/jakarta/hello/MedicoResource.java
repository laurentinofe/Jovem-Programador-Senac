package br.com.senac.jakarta.hello;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("medicos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MedicoResource {

    public static List<String> dados = new ArrayList<>(); //"Static" garante que  o código use sempre a mesma lista

    @GET
    //@Path("buscar") // Caminho / QueryParam: não obrigatório parâmetros
    public List<String> meuEndPointGet2(@QueryParam("nomeMedico") String nome,
                                        @QueryParam("sobrenomeMedico") String sobrenome) {
        return dados;
    }

    @GET
    @Path("{nomeURL}") //variável / PathParam: obrigatório parâmetros
    public String parametroURL(@PathParam("nomeURL") String nome) {
        return nome;
    }


    @POST
    public void salvar(String nome) {
        dados.add(nome);
    }

    @PUT
    @Path("atualizar/{id}")
    public void atualizar(@PathParam("id") int id, String nome){
        dados.set(id, nome);
    }

    @DELETE
    @Path("excluir/{id}")

    public void excluir (@PathParam("id") int id){
        dados.remove(id);
    }


}