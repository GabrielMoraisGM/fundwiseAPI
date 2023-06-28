package com.fund.wise.api.fundwise.service;

import com.fund.wise.api.fundwise.dto.ativo.AtivoDto;
import com.fund.wise.api.fundwise.model.Ativo;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

public interface IAtivoService {

    public Ativo salvarAtivo(Ativo novoAtivo);

    public Ativo pesquisarAtivoPorId(Long id) throws ChangeSetPersister.NotFoundException;

    public void deletarAtivoPorId(Long id);
}
