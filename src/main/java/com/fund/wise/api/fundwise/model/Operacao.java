package com.fund.wise.api.fundwise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperacao;

    private UUID codigoOperacao = UUID.randomUUID();

    private Integer tipoOperacao;

    @NotNull(message = "O campo valor não pode ser nulo")
    private Double valor;

    @OneToMany(mappedBy = "operacao")
    private List<Ativo> ativos;

    @NotNull(message = "O campo idAtivo não pode ser nulo")
    private List<Long> idAtivos;

    @Deprecated
    public Operacao(){}

    public Operacao(Long idOperacao,Integer tipoOperacao, Double valor, List<Long> idAtivos){
        this.idOperacao = idOperacao;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.idAtivos = idAtivos;
    }

    public Operacao(Integer tipoOperacao, Double valor, List<Long> idAtivos){
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.idAtivos = idAtivos;
    }

    public Long getIdOperacao() {return idOperacao;}
    public void setIdOperacao(Long idOperacao) { this.idOperacao = idOperacao; }
    public Double getValor() {return valor;}
    public void setValor(Double valor) {this.valor = valor;}
    public UUID getCodigoOperacao() {return codigoOperacao;}
    public void setCodigoOperacao(UUID codigoOperacao) {this.codigoOperacao = codigoOperacao;}
    public Integer getTipoOperacao() {return tipoOperacao;}
    public void setTipoOperacao(Integer tipoOperacao) {this.tipoOperacao = tipoOperacao;}
    public List<Ativo> getAtivos() {return ativos;}
    public void setAtivos(List<Ativo> ativos) {this.ativos = ativos;}
    public List<Long> getIdAtivos() {return idAtivos;}
    public void setIdAtivos(List<Long> idAtivos) {this.idAtivos = idAtivos;}
}
