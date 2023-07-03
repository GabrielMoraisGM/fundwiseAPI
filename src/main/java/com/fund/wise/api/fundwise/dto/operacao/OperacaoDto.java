package com.fund.wise.api.fundwise.dto.operacao;

import com.fund.wise.api.fundwise.model.Operacao;
import java.util.List;

public class OperacaoDto {

    private Integer tipoOperacao;
    private Double valor;
    private List<Long> idAtivos;

    @Deprecated
    public OperacaoDto(){}

    public OperacaoDto(int tipoOperacao, double valor, List<Long> idAtivos){
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.idAtivos = idAtivos;
    }

    public Operacao toEntity(){
       return new Operacao(tipoOperacao ,valor, idAtivos);
    }

    public Integer getTipoOperacao() {
        return tipoOperacao;
    }
    public void setTipoOperacao(Integer tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public List<Long> getIdAtivos() {return idAtivos;}
    public void setIdAtivos(List<Long> idAtivos) {this.idAtivos = idAtivos;}
}
