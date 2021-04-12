package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.udemy.compras.models.Compra;
import com.udemy.compras.models.Produto;
import com.udemy.compras.services.CompraService;
import com.udemy.compras.services.ProdutoService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class Subscription implements GraphQLSubscriptionResolver {

    @Autowired
    private ProdutoService produtoService;

    public Publisher<List<Produto>> listProdutos(){

        return subscriber -> Executors.newScheduledThreadPool(1).scheduleAtFixedRate(()->{
            List<Produto> prds = (List<Produto>) produtoService.findAll();
            subscriber.onNext(prds);
        }, 0,5, TimeUnit.SECONDS);

    }

}
