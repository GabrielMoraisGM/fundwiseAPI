package com.fund.wise.api.fundwise.service.imp;

import com.fund.wise.api.fundwise.dto.ativo.AtivoViewDto;
import com.fund.wise.api.fundwise.model.Ativo;
import com.fund.wise.api.fundwise.model.Operacao;
import com.fund.wise.api.fundwise.repository.AtivoRepository;
import com.fund.wise.api.fundwise.repository.OperacaoRepository;
import com.fund.wise.api.fundwise.service.IOperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperacaoService implements IOperacaoService {

    @Autowired
    OperacaoRepository operacaoRepository;

    @Autowired
    AtivoRepository ativoRepository;

    @Override
    public Operacao salvarOperacao(Operacao novaOperacao) {
        novaOperacao.setAtivos(preencherAtivo(novaOperacao));
        return operacaoRepository.save(novaOperacao);
    }

    @Override
    public Optional<Operacao> pesquisarOperacaoPorId(Long id) {
        Optional<Operacao> retorno = operacaoRepository.findById(id);
        return retorno;
    }

    @Override
    public void deletarOperacaoPorId(Long id) {

    }

    //Recebe uma operação como parametro e retorna uma lista de ativos (serve para associar estes ativos à operação em questão)
    private List<Ativo> preencherAtivo(Operacao operacao) throws IllegalArgumentException{

        List<Ativo> ativos = new ArrayList<>();

        for (Long item: operacao.getIdAtivos()) {

            Optional<Ativo> optional = ativoRepository.findById(item);

            if(optional.isPresent()){
                ativos.add(optional.get());
            }
            else{
                throw new IllegalArgumentException("id do ativo inválido");
            }
        }

        return ativos;
    }
}
