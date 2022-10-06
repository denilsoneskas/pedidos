package com.eskas.pedidos.controller;

import com.eskas.pedidos.model.Endereco;
import com.eskas.pedidos.model.Promocao;
import com.eskas.pedidos.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping
    public  List<Endereco> listarTodos(){
        return enderecoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco){
        enderecoRepository.save(endereco);
        return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Endereco> deletar(@PathVariable Long id){
        Optional<Endereco> enderecoEncontrado = enderecoRepository.findById(id);
        if(enderecoEncontrado.isPresent()){
            enderecoRepository.deleteById(enderecoEncontrado.get().getId());
            return new ResponseEntity<Endereco>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Endereco> atualizarParcial(@PathVariable Long id, @RequestBody Endereco endereco) {
        Optional<Endereco> enderecoEncontrado = enderecoRepository.findById(id);
        if(enderecoEncontrado.isPresent()){
            endereco.setId(id);
            enderecoRepository.save(endereco);
            return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
        } else {
            return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
        }
    }
}
