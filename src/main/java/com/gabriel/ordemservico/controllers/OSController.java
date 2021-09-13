package com.gabriel.ordemservico.controllers;

import com.gabriel.ordemservico.domain.Cliente;
import com.gabriel.ordemservico.domain.OS;
import com.gabriel.ordemservico.dtos.OSDto;
import com.gabriel.ordemservico.services.OSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/os")
public class OSController {

    @Autowired
    OSService service;

    @GetMapping
    public ResponseEntity<List<OS>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OS> findById(@RequestParam Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<OS> create(@RequestBody OSDto obj){
        return ResponseEntity.ok().body(service.create(obj));
    }

    @PutMapping
    public ResponseEntity<OS> update(@RequestBody OS obj){
        return ResponseEntity.ok().body(service.update(obj));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
