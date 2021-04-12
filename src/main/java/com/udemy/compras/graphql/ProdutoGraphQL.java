package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.models.Cliente;
import com.udemy.compras.models.Produto;
import com.udemy.compras.models.ProdutoInput;
import com.udemy.compras.services.ProdutoService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService service;

    public List<Produto> produtos (){
        return service.findAll();
    }

    public Boolean deleteProduto(Long id){
        return service.deleteById(id);
    }

    public Produto saveProduto(ProdutoInput produtoInput){
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoInput, Produto.class);

        return service.save(produto);

    }


}
