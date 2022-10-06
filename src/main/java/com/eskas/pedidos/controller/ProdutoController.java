package com.eskas.pedidos.controller;

import com.eskas.pedidos.model.Produto;
import com.eskas.pedidos.model.Promocao;
import com.eskas.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public  List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        produtoRepository.save(produto);
        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Produto> deletar(@PathVariable Long id){
        Optional<Produto> produtoEncontrado = produtoRepository.findById(id);
        if(produtoEncontrado.isPresent()){
            produtoRepository.deleteById(produtoEncontrado.get().getId());
            return new ResponseEntity<Produto>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Produto> atualizarParcial(@PathVariable Long id, @RequestBody Produto produto) {
        Optional<Produto> produtoEncontrado = produtoRepository.findById(id);
        if(produtoEncontrado.isPresent()){
            produto.setId(id);
            produtoRepository.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
        }
    }
}
