package com.fund.wise.api.fundwise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ativo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtivo;

    @NotBlank(message = "O campo sigla é obrigatório")
    private String sigla;

    @NotNull(message = "O campo valor não pode ser nulo")
    private Double valor;

    @NotBlank(message = "O campo setor é obrigatório")
    private String setor;

    @NotBlank(message = "O campo tipo é obrigatório")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_operacao", nullable = true)
    private Operacao operacao;

    @Deprecated
    public Ativo(){}

    public Ativo(String sigla, String setor, String tipo, Double valor){
        this.sigla = sigla;
        this.setor = setor;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Long getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(Long idAtivo) {
        this.idAtivo = idAtivo;
    }

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

    //EM TESTE
    //public Operacao getOperacao() {return operacao;}

    //public void setOperacao(Operacao operacao) {this.operacao = operacao;}
}
