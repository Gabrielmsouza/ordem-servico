package com.gabriel.ordemservico.services;

import com.gabriel.ordemservico.domain.Cliente;
import com.gabriel.ordemservico.domain.Pessoa;
import com.gabriel.ordemservico.repositories.ClienteRepository;
import com.gabriel.ordemservico.repositories.PessoaRepository;
import com.gabriel.ordemservico.services.exceptions.DataIntegrityException;
import com.gabriel.ordemservico.services.exceptions.ObjectNotFoundException;
import com.gabriel.ordemservico.utils.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    @Autowired
    PessoaRepository pessoaRepository;

    public Cliente create(Cliente obj) {
        if (findByCpf(obj) != null) {
            throw new DataIntegrityException(Mensagem.CPF_JA_CADASTRADO(obj.getCpf()));
        }

        return repository.save(obj);
    }

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(Mensagem.CLIENTE_NAO_ENCONTRADO));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente update(Cliente obj) {
        findById(obj.getId());

        Pessoa pessoa = findByCpf(obj);
        if (pessoa != null && !pessoa.getId().equals(obj.getId())){
            throw new DataIntegrityException(Mensagem.CPF_JA_CADASTRADO(obj.getCpf()));
        }

        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    public Pessoa findByCpf(Cliente obj){
        Pessoa pessoa = pessoaRepository.findByCPF(obj.getCpf());
        if (pessoa != null) return pessoa;
        return null;
    }
}
