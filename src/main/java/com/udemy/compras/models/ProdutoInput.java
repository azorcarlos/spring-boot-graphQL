package com.udemy.compras.models;


import lombok.Data;

@Data
public class ProdutoInput {

    private Long id;
    private String nome;
    private Float valor;
}
