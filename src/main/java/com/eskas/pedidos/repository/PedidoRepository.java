package com.eskas.pedidos.repository;

import com.eskas.pedidos.model.Cidade;
import com.eskas.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
