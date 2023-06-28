package com.fund.wise.api.fundwise.dto.operacao;

import com.fund.wise.api.fundwise.model.Ativo;
import com.fund.wise.api.fundwise.model.Operacao;
import com.fund.wise.api.fundwise.repository.AtivoRepository;

import java.util.ArrayList;
import java.util.List;

public class OperacaoDto {

    private int tipoOperacao;
    private double valor;
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

    public int getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(int tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Long> getIdAtivos() {return idAtivos;}

    public void setIdAtivos(List<Long> idAtivos) {this.idAtivos = idAtivos;}
}
