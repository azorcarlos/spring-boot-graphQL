package com.udemy.compras.services;


import com.udemy.compras.graphql.dto.CompraResumo;
import com.udemy.compras.graphql.exceptions.DomainException;
import com.udemy.compras.models.Cliente;
import com.udemy.compras.models.Compra;
import com.udemy.compras.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository rep;

    public Compra findById(Long id) {
        return rep.findById(id).orElse(null);
    }

    public List<Compra> findAll(Pageable pageble) {
        return rep.findAll(pageble).getContent();
    }

    @Transactional
    //@CacheEvict(value = "comprasByCliente",key = "#c.cliente.id")
    public Compra save(Compra c) {
        final int QUANTIDADE = 100;

        if(c.getQuantidade() >QUANTIDADE){
            throw new DomainException("Quantidade não pode ser maior que 100");
        }
        return rep.save(c);
    }

    @Transactional
    public boolean deleteById(Long id) {
        if(rep.findById(id).isPresent()) {
            rep.deleteById(id);
            return true;
        }
        return false;
    }

    //@Cacheable(value = "comprasByCliente", key = "#cliente.id")
    public List<Compra> findAllByCliente(Cliente cliente) {

        return  rep.findAllByCliente(cliente.getId());
    }

    public List<CompraResumo> findAllComprasRelatorio() {

        return rep.findAllComprasRelatorio();
    }

    public List<Compra> findAll() {
        System.out.println("teste");
        return (List<Compra>) rep.findAll();
    }
}
