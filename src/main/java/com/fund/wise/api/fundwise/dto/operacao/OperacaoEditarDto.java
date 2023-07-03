package com.fund.wise.api.fundwise.dto.operacao;

import com.fund.wise.api.fundwise.model.Operacao;

import java.util.List;

public class OperacaoEditarDto{

    private Long idOperacao;
    private Integer tipoOperacao;
    private Double valor;
    private List<Long> idAtivos;

    public OperacaoEditarDto(Long idOperacao, Integer tipoOperacao, Double valor, List<Long> idAtivos){
        this.idOperacao = idOperacao;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.idAtivos = idAtivos;
    }

    public Operacao toEntity(){
        return new Operacao(idOperacao,tipoOperacao, valor, idAtivos);
    }

    public Long getIdOperacao() {return idOperacao;}
    public void setIdOperacao(Long idOperacao) {this.idOperacao = idOperacao;}
    public Integer getTipoOperacao() {return tipoOperacao;}
    public void setTipoOperacao(Integer tipoOperacao) {this.tipoOperacao = tipoOperacao;}
    public Double getValor() {return valor;}
    public void setValor(Double valor) {this.valor = valor;}
    public List<Long> getIdAtivos() {return idAtivos;}
    public void setIdAtivos(List<Long> idAtivos) {this.idAtivos = idAtivos;}
}
