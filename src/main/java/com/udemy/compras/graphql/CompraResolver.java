package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.models.Cliente;
import com.udemy.compras.models.Compra;
import com.udemy.compras.models.Produto;
import com.udemy.compras.services.ClienteService;
import com.udemy.compras.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clieneService;

    @Autowired
    private ProdutoService produtoService;

    public String status (Compra c ){
        return "Teste :"+c.getStatus();
    }
    public Cliente cliente(Compra c){
        return clieneService.findById(c.getCliente().getId());
    }

    public Produto produto(Compra c){
        return produtoService.findById(c.getProduto().getId());
    }

}
