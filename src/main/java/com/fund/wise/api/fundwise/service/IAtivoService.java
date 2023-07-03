package com.fund.wise.api.fundwise.service;

import com.fund.wise.api.fundwise.model.Ativo;

public interface IAtivoService {

    public Ativo salvarAtivo(Ativo novoAtivo);

    public Ativo pesquisarAtivoPorId(Long id);

    public Ativo atualizarAtivo(Ativo ativoAtualizado);

    public void deletarAtivoPorId(Long id);
}
