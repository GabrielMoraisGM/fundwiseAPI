package com.fund.wise.api.fundwise.service;

import com.fund.wise.api.fundwise.model.Operacao;
import java.util.Optional;

public interface IOperacaoService {

    public Operacao salvarOperacao(Operacao novaOperacao);
    public Operacao pesquisarOperacaoPorId(Long id);
    public Operacao atualizarOperacaoPorId(Operacao operacaoAtualizada);
    public void deletarOperacaoPorId(Long id);
}
