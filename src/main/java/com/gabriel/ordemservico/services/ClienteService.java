package com.gabriel.ordemservico.services;

import com.gabriel.ordemservico.domain.Cliente;
import com.gabriel.ordemservico.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Cliente create(Cliente obj) {
        return repository.save(obj);
    }

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(0,"Cliente não encontrado!"));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente update(Cliente obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
