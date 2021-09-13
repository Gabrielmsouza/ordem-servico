package com.gabriel.ordemservico.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriel.ordemservico.domain.OS;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OSDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAbetura;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataFechamento;
    private Integer tecnico;
    private Integer cliente;
    private Integer prioridade;
    private Integer status;

    public OSDto() {
        super();
    }

    public OSDto(OS os) {
        this.id = os.getId();
        this.dataAbetura = os.getDataAbetura();
        this.dataFechamento = os.getDataFechamento();
        this.tecnico = os.getTecnico().getId();
        this.cliente = os.getCliente().getId();
        this.prioridade = os.getPrioridade();
        this.status = os.getStatus();
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

    public Integer getTecnico() {
        return tecnico;
    }

    public void setTecnico(Integer tecnico) {
        this.tecnico = tecnico;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
