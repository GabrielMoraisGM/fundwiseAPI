package com.fund.wise.api.fundwise.dto.ativo;

import com.fund.wise.api.fundwise.model.Ativo;

public class AtivoDto{

    private String sigla;
    private String setor;
    private String tipo;
    private Double valor;

    @Deprecated
    public AtivoDto(){}

    public AtivoDto(String sigla, String setor, String tipo, Double valor){
        this.sigla = sigla;
        this.setor = setor;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Ativo toEntity(){return new Ativo(sigla, setor, tipo, valor);}

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
