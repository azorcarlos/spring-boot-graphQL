package com.udemy.compras.repository;

import com.udemy.compras.graphql.dto.CompraResumo;
import com.udemy.compras.models.Cliente;
import com.udemy.compras.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {



    @Query("select c from Compra c Where c.cliente.id = :clienteId")
    public List<Compra> findAllByCliente(@Param("clienteId") Long  clienteId);

    @Query("select new com.udemy.compras.graphql.dto.CompraResumo(c.id, cli.nome, p.nome, c.quantidade) from Compra c inner join c.cliente cli inner join c.produto p ")
    List<CompraResumo> findAllComprasRelatorio();

    // public List<Compra> findAllByCliente2(Cliente cliente);

}
