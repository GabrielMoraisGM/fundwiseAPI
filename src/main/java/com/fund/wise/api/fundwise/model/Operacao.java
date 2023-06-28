package com.fund.wise.api.fundwise.model;

import com.fund.wise.api.fundwise.dto.ativo.AtivoViewDto;
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

    private int tipoOperacao;

    @NotNull(message = "O campo valor não pode ser nulo")
    private double valor;

    @OneToMany(mappedBy = "operacao")
    private List<Ativo> ativos;

    @NotNull(message = "O campo idAtivo não pode ser nulo")
    private List<Long> idAtivos;

    @Deprecated
    public Operacao(){}

    public Operacao(int tipoOperacao, double valor, List<Long> idAtivos){
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.idAtivos = idAtivos;
    }

    public Long getIdOperacao() {return idOperacao;}

    public void setIdOperacao(Long idOperacao) { this.idOperacao = idOperacao; }

    public double getValor() {return valor;}

    public void setValor(double valor) {this.valor = valor;}

    public UUID getCodigoOperacao() {return codigoOperacao;}

    public void setCodigoOperacao(UUID codigoOperacao) {this.codigoOperacao = codigoOperacao;}

    public int getTipoOperacao() {return tipoOperacao;}

    public void setTipoOperacao(int tipoOperacao) {this.tipoOperacao = tipoOperacao;}

    public List<Ativo> getAtivos() {return ativos;}

    public void setAtivos(List<Ativo> ativos) {this.ativos = ativos;}

    //EM TESTE

    public List<Long> getIdAtivos() {return idAtivos;}

    public void setIdAtivos(List<Long> idAtivos) {this.idAtivos = idAtivos;}
}
