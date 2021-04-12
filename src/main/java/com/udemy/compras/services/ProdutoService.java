package com.udemy.compras.services;

import com.udemy.compras.models.Produto;
import com.udemy.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    @Transactional
    public Boolean deleteById(Long id){

       if(produtoRepository.findById(id).isPresent()){
           produtoRepository.deleteById(id);

           return true;
       }
        return false;
    }

    @Transactional
    public Produto save(Produto produto){

        return produtoRepository.save(produto);
    }

    public Produto findById (Long id){
        return produtoRepository.findById(id).get();
    }

}
