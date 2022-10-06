package com.eskas.pedidos.controller;

import com.eskas.pedidos.model.Cidade;
import com.eskas.pedidos.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cidade")
public class CidadeController {
    @Autowired
    CidadeRepository cidadeRepository;

    @GetMapping
    public  List<Cidade> listarTodos(){
        return cidadeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade){
        cidadeRepository.save(cidade);
        return new ResponseEntity<Cidade>(cidade, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Cidade> deletar(@PathVariable Long id){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if(cidade.isPresent()){
            cidadeRepository.deleteById(cidade.get().getId());
            return new ResponseEntity<Cidade>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Cidade>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Cidade> atualizarParcial(@PathVariable Long id, @RequestBody Cidade cidade) {
        Optional<Cidade> cidadeEncontrada = cidadeRepository.findById(id);
        if(cidadeEncontrada.isPresent()){
            cidade.setId(id);
            cidadeRepository.save(cidade);
            return new ResponseEntity<Cidade>(cidade, HttpStatus.OK);
        } else {
            return new ResponseEntity<Cidade>(HttpStatus.NOT_FOUND);
        }
    }
}
