package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.udemy.compras.graphql.dto.CompraResumo;
import com.udemy.compras.models.Compra;
import com.udemy.compras.models.CompraInput;
import com.udemy.compras.services.ClienteService;
import com.udemy.compras.services.CompraService;
import com.udemy.compras.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class CompraGraphQL  implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Compra compra(Long id) {

        return service.findById(id);
    }

    public List<Compra> getCompras(int page, int size) {
        Pageable pageble = PageRequest.of(page, size, Sort.by("quantidade").descending());
        return service.findAll(pageble);
    }

    public List<CompraResumo> getComprasRelatorio() {
        return service.findAllComprasRelatorio();
    }

    public Compra saveCompra(CompraInput input) {
        ModelMapper m = new ModelMapper();
        Compra c = m.map(input,Compra.class);

        c.setData(new Date());

        c.setCliente(clienteService.findById(input.getClienteId()));
        c.setProduto(produtoService.findById(input.getProdutoId()));

        return service.save(c);
    }

    public Boolean deleteCompra(Long id) {
        return service.deleteById(id);
    }


}
