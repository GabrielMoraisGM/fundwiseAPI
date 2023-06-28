package com.fund.wise.api.fundwise.dto.ativo;

import com.fund.wise.api.fundwise.model.Ativo;

import java.util.Optional;

public class AtivoViewDto{

    private String sigla;
    private String tipo;

    @Deprecated
    public AtivoViewDto(){}

    public AtivoViewDto(Optional<Ativo> ativo){
        this.sigla = ativo.get().getSigla();
        this.tipo = ativo.get().getTipo();
    }

    public String getSigla() {return sigla;}

    public void setSigla(String sigla) {this.sigla = sigla;}

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}
}
