package com.fund.wise.api.fundwise.service;

import com.fund.wise.api.fundwise.model.Operacao;
import java.util.Optional;

public interface IOperacaoService {

    public Operacao salvarOperacao(Operacao novaOperacao);
    public Optional<Operacao> pesquisarOperacaoPorId(Long id);
    public void deletarOperacaoPorId(Long id);
}
