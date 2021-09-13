package com.gabriel.ordemservico.domain;

import com.gabriel.ordemservico.domain.enums.Prioridade;
import com.gabriel.ordemservico.domain.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class OS implements Serializable {
    private static final long serialVersionUID = -7654211121554624839L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataAbetura;
    private LocalDate dataFechamento;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Integer prioridade;
    private Integer status;

    public OS() {
        super();

        this.setDataAbetura(LocalDateTime.now());
        this.setPrioridade(Prioridade.BAIXA);
        this.setStatus(Status.ABERTO);
    }

    public OS(Integer id, Tecnico tecnico, Cliente cliente, Prioridade prioridade, Status status) {
        this.id = id;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.prioridade = (prioridade == null) ? 0 : prioridade.getCod();
        this.status = (status == null) ? 0 : status.getCod();

        this.setDataAbetura(LocalDateTime.now());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAbetura() {
        return dataAbetura;
    }

    public void setDataAbetura(LocalDateTime dataAbetura) {
        this.dataAbetura = dataAbetura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade.getCod();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.getCod();
    }
}
