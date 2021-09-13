package com.gabriel.ordemservico.services;

import com.gabriel.ordemservico.domain.Tecnico;
import com.gabriel.ordemservico.repositories.TecnicoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    TecnicoRepository repository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException(0,"Tecnico não encontrado!"));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(Tecnico obj) {
        return repository.save(obj);
    }

    public Tecnico update(Tecnico obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
