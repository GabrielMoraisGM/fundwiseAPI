package com.fund.wise.api.fundwise.dto.operacao;

import com.fund.wise.api.fundwise.model.Ativo;

import java.util.List;
import java.util.UUID;

public class OperacaoViewDto {

    //propriedades de retorno
    private Long idOperacao;

    private UUID codigoOperacao;
    private String tipoOperacao;
    private double valor;
    private List<Ativo> ativos;

    public OperacaoViewDto(UUID codigoOperacao, String tipoOperacao, double valor, List<Ativo> ativos, Long idOperacao){
        this.codigoOperacao = codigoOperacao;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.ativos = ativos;
        this.idOperacao = idOperacao;
    }

    public UUID getCodigoOperacao() {
        return codigoOperacao;
    }

    public void setCodigoOperacao(UUID codigoOperacao) {
        this.codigoOperacao = codigoOperacao;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Ativo> getAtivos() {return ativos;}

    public void setAtivos(List<Ativo> ativos) {this.ativos = ativos;}

    public Long getIdOperacao() {return idOperacao;}

    public void setIdOperacao(Long idOperacao) {this.idOperacao = idOperacao;}
}
