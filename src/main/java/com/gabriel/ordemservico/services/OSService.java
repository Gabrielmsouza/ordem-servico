package com.gabriel.ordemservico.services;

import com.gabriel.ordemservico.domain.Cliente;
import com.gabriel.ordemservico.domain.OS;
import com.gabriel.ordemservico.domain.Tecnico;
import com.gabriel.ordemservico.domain.enums.Prioridade;
import com.gabriel.ordemservico.domain.enums.Status;
import com.gabriel.ordemservico.dtos.OSDto;
import com.gabriel.ordemservico.repositories.OSRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OSService {

    @Autowired
    OSRepository repository;

    @Autowired
    ClienteService serviceCliente;

    @Autowired
    TecnicoService serviceTecnico;

    public List<OS> findAll() {
        return repository.findAll();
    }

    public OS findById(Integer id) {
        Optional<OS> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(0,"OS não localizada!"));
    }

    public OS create(OSDto obj) {
        return repository.save(fromDTO(obj));
    }

    public OS update(OS obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    private OS fromDTO(OSDto obj) {
        Cliente objCli = serviceCliente.findById(obj.getCliente());
        Tecnico objTec = serviceTecnico.findById(obj.getTecnico());

        OS os = new OS();
        os.setId(obj.getId());
        os.setDataAbetura(obj.getDataAbetura());
        os.setDataFechamento(obj.getDataFechamento());
        os.setTecnico(objTec);
        os.setCliente(objCli);
        os.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        os.setStatus(Status.toEnum(obj.getStatus()));
        return os;
    }
}
