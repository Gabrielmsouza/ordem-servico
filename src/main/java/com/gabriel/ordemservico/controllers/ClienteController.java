package com.gabriel.ordemservico.controllers;

import com.gabriel.ordemservico.domain.Cliente;
import com.gabriel.ordemservico.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente obj){
        return ResponseEntity.ok().body(service.create(obj));
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente obj){
        return ResponseEntity.ok().body(service.update(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
