package com.gabriel.ordemservico.services;

import antlr.collections.List;
import com.gabriel.ordemservico.domain.Cliente;
import com.gabriel.ordemservico.domain.OS;
import com.gabriel.ordemservico.domain.Tecnico;
import com.gabriel.ordemservico.domain.enums.Prioridade;
import com.gabriel.ordemservico.domain.enums.Status;
import com.gabriel.ordemservico.repositories.ClienteRepository;
import com.gabriel.ordemservico.repositories.OSRepository;
import com.gabriel.ordemservico.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    OSRepository osRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    TecnicoRepository tecnicoRepository;

    public void iniciaDb(){
        Tecnico t1 = new Tecnico(null,"Eduardo Bandeira", "486.081.470-33","");
        Tecnico t2 = new Tecnico(null,"Rafael Silva", "744.490.520-72","");
        Tecnico t3 = new Tecnico(null,"Emanuel Salgado", "687.824.950-33","");
        Tecnico t4 = new Tecnico(null,"Aleir Neto", "778.151.990-62","");
        Tecnico t5 = new Tecnico(null,"Kelvin Rascke", "767.703.080-70","");
        Tecnico t6 = new Tecnico(null,"Joilson Borba", "036.463.910-57","");

        Cliente c1 = new Cliente(null,"Zelia da Silva Marcilio","740.166.080-66","");
        Cliente c2 = new Cliente(null,"Marcelino de Souza","127.436.340-30","");
        Cliente c3 = new Cliente(null,"Gabrielly Prudencio","181.858.020-92","");
        Cliente c4 = new Cliente(null,"Diogo Matei","117.354.930-74","");
        Cliente c5 = new Cliente(null,"Cleiton Marcelino","122.964.060-68","");

        OS os1 = new OS(null,t1,c3, Prioridade.BAIXA, Status.ABERTO);
        OS os2 = new OS(null,t4,c1,Prioridade.ALTA,Status.ABERTO);
        OS os3 = new OS(null,t5,c2,Prioridade.MEDIA,Status.ABERTO);
        OS os4 = new OS(null,t2,c5,Prioridade.BAIXA,Status.FECHADO);

        clienteRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
        tecnicoRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6));
        osRepository.saveAll(Arrays.asList(os1,os2,os3,os4));

    }
}
