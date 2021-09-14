package com.gabriel.ordemservico.controllers;

import com.gabriel.ordemservico.domain.Tecnico;
import com.gabriel.ordemservico.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {

    @Autowired
    TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tecnico> findById (@PathVariable Integer id){
        Tecnico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Tecnico>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Tecnico> create(@RequestBody Tecnico obj){
        System.out.printf(obj.getNome());
        return ResponseEntity.ok().body(service.create(obj));
    }

    @PutMapping
    public ResponseEntity<Tecnico> update(@RequestBody Tecnico obj){
        return ResponseEntity.ok().body(service.update(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
