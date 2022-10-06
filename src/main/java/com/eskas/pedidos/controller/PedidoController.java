package com.eskas.pedidos.controller;

import com.eskas.pedidos.model.Pedido;
import com.eskas.pedidos.model.Produto;
import com.eskas.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public  List<Pedido> listarTodos(){
        return pedidoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido){
        pedidoRepository.save(pedido);
        return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Pedido> deletar(@PathVariable Long id){
        Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(id);
        if(pedidoEncontrado.isPresent()){
            pedidoRepository.deleteById(pedidoEncontrado.get().getId());
            return new ResponseEntity<Pedido>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Pedido> atualizarParcial(@PathVariable Long id, @RequestBody Pedido pedido) {
        Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(id);
        if(pedidoEncontrado.isPresent()){
            pedido.setId(id);
            pedidoRepository.save(pedido);
            return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
        }
    }
}
