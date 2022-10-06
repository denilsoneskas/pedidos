package com.eskas.pedidos.repository;

import com.eskas.pedidos.model.Pessoa;
import com.eskas.pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
