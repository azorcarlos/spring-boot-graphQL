package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.models.Produto;
import graphql.GraphQL;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

    public String valorReais(Produto produto){
        return "R$: "+produto.getValor();
    }
}
