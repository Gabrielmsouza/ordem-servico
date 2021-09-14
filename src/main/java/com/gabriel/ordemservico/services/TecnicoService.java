package com.gabriel.ordemservico.services;

import com.gabriel.ordemservico.domain.Pessoa;
import com.gabriel.ordemservico.domain.Tecnico;
import com.gabriel.ordemservico.repositories.PessoaRepository;
import com.gabriel.ordemservico.repositories.TecnicoRepository;
import com.gabriel.ordemservico.utils.Mensagem;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    TecnicoRepository repository;

    @Autowired
    PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException(0,Mensagem.TECNICO_NAO_ENCONTRADO));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(Tecnico obj) {
        if (findByCpf(obj) != null){
            throw new DataIntegrityViolationException(Mensagem.CPF_JA_CADASTRADO);
        }

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

    public Pessoa findByCpf(Tecnico obj){
        Pessoa pessoa = pessoaRepository.findByCPF(obj.getCpf());
        if (pessoa != null) return pessoa;
        return null;
    }
}
