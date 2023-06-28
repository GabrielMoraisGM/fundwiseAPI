package com.fund.wise.api.fundwise.service.imp;

import com.fund.wise.api.fundwise.dto.ativo.AtivoDto;
import com.fund.wise.api.fundwise.model.Ativo;
import com.fund.wise.api.fundwise.repository.AtivoRepository;
import com.fund.wise.api.fundwise.service.IAtivoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AtivoService implements IAtivoService {

    @Autowired
    AtivoRepository ativoRepository;

    @Override
    public Ativo salvarAtivo(Ativo novoAtivo) {
        return ativoRepository.save(novoAtivo);
    }

    @Override
    public Ativo pesquisarAtivoPorId(Long id) throws NoSuchElementException {
        try{
            Ativo ativoLocalizado = ativoRepository.findById(id).get();
            return ativoLocalizado;
        }catch (NoSuchElementException ex){
            throw new NoSuchElementException("ID nao encontrado no banco de dados!");
        }
    }

    @Override
    public void deletarAtivoPorId(Long id) {
        try{
            Ativo ativoLocalizado = pesquisarAtivoPorId(id);
            ativoRepository.delete(ativoLocalizado);
        }catch (HttpServerErrorException.InternalServerError ex) {throw ex;}
    }
}
