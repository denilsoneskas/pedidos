package com.eskas.pedidos.controller;

import com.eskas.pedidos.model.Pessoa;
import com.eskas.pedidos.model.Promocao;
import com.eskas.pedidos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping
    public  List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa){
        pessoaRepository.save(pessoa);
        return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Pessoa> deletar(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            pessoaRepository.deleteById(pessoa.get().getId());
            return new ResponseEntity<Pessoa>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Pessoa> atualizarParcial(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Optional<Pessoa> pessoaEncontrada = pessoaRepository.findById(id);
        if(pessoaEncontrada.isPresent()){
            pessoa.setId(id);
            pessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        } else {
            return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
        }
    }
}
