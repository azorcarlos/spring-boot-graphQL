package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.models.Cliente;
import com.udemy.compras.models.Compra;
import com.udemy.compras.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    private CompraService compraService;

    public List<Compra>compras (Cliente c ){
        return compraService.findAllByCliente(c);
    }

}
