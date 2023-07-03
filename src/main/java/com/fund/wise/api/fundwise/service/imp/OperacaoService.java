package com.fund.wise.api.fundwise.service.imp;

import com.fund.wise.api.fundwise.dto.operacao.OperacaoEditarDto;
import com.fund.wise.api.fundwise.model.Ativo;
import com.fund.wise.api.fundwise.model.Operacao;
import com.fund.wise.api.fundwise.repository.AtivoRepository;
import com.fund.wise.api.fundwise.repository.OperacaoRepository;
import com.fund.wise.api.fundwise.service.IOperacaoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

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
    public Operacao pesquisarOperacaoPorId(Long id){

        Optional<Operacao> operacaoBd = operacaoRepository.findById(id);

        if(operacaoBd.isPresent()){
            Operacao operacaBdEncontrada = operacaoBd.get();
            operacaBdEncontrada.setAtivos(preencherAtivo(operacaBdEncontrada));
            return operacaBdEncontrada;
        }
        else throw new EntityNotFoundException("Operação com Id: " + id + " não encontrada!");
    }

    @Override
    public void deletarOperacaoPorId(Long id) {
        Operacao operacaoBD = pesquisarOperacaoPorId(id);

        try {operacaoRepository.delete(operacaoBD);}
        catch (HttpServerErrorException ex) { throw ex; }
    }

    @Override
    public Operacao atualizarOperacaoPorId(Operacao operacaoAtualizada){

        Operacao operacaoDb = pesquisarOperacaoPorId(operacaoAtualizada.getIdOperacao());

        if(operacaoAtualizada.getTipoOperacao() != null) operacaoDb.setTipoOperacao(operacaoAtualizada.getTipoOperacao());
        if(operacaoAtualizada.getValor() != null) operacaoDb.setValor(operacaoAtualizada.getValor());
        if(operacaoAtualizada.getIdAtivos() != null) operacaoDb.setIdAtivos(operacaoAtualizada.getIdAtivos());

        operacaoDb.setAtivos(preencherAtivo(operacaoDb));

        return operacaoRepository.save(operacaoDb);
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
