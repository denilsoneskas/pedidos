package com.eskas.pedidos.controller;

import com.eskas.pedidos.model.Promocao;
import com.eskas.pedidos.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("promocao")
public class PromocaoController {
    @Autowired
    PromocaoRepository promocaoRepository;

    @GetMapping
    public  List<Promocao> listarTodos(){
        return promocaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Promocao> salvar(@RequestBody Promocao promocao){
        promocaoRepository.save(promocao);
        return new ResponseEntity<Promocao>(promocao, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Promocao> deletar(@PathVariable Long id){
        Optional<Promocao> promocao = promocaoRepository.findById(id);
        if(promocao.isPresent()){
            promocaoRepository.deleteById(promocao.get().getId());
            return new ResponseEntity<Promocao>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Promocao>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Promocao> atualizarParcial(@PathVariable Long id, @RequestBody Promocao promocao) {
        Optional<Promocao> promocaoEncontrada = promocaoRepository.findById(id);
        if(promocaoEncontrada.isPresent()){
            promocao.setId(id);
            promocaoRepository.save(promocao);
            return new ResponseEntity<Promocao>(promocao, HttpStatus.OK);
        } else {
            return new ResponseEntity<Promocao>(HttpStatus.NOT_FOUND);
        }
    }
}
