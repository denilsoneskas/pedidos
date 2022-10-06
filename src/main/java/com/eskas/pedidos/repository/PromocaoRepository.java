package com.eskas.pedidos.repository;

import com.eskas.pedidos.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoRepository  extends JpaRepository<Promocao, Long> {
}
