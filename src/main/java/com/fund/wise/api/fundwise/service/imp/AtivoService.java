package com.fund.wise.api.fundwise.service.imp;

import com.fund.wise.api.fundwise.model.Ativo;
import com.fund.wise.api.fundwise.repository.AtivoRepository;
import com.fund.wise.api.fundwise.service.IAtivoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

        Optional<Ativo> ativoLocalizado = ativoRepository.findById(id);

        if(ativoLocalizado.isPresent()) return ativoLocalizado.get();
        else throw new EntityNotFoundException("Elemento com id: " +id+ " não encontrado!");
    }

    @Override
    public Ativo atualizarAtivo(Ativo ativoAtualizado){

        Ativo ativoDb = pesquisarAtivoPorId(ativoAtualizado.getIdAtivo());

        if(ativoAtualizado.getSigla() != null) ativoDb.setSigla(ativoAtualizado.getSigla());
        if(ativoAtualizado.getValor() != null) ativoDb.setValor(ativoAtualizado.getValor());
        if(ativoAtualizado.getSetor() != null) ativoDb.setSetor(ativoAtualizado.getSetor());
        if(ativoAtualizado.getTipo() != null) ativoDb.setTipo(ativoAtualizado.getTipo());

        return ativoRepository.save(ativoDb);
    }

    @Override
    public void deletarAtivoPorId(Long id) {
        try{
            Ativo ativoLocalizado = pesquisarAtivoPorId(id);
            ativoRepository.delete(ativoLocalizado);
        }catch (HttpServerErrorException.InternalServerError ex) {throw ex;}
    }
}
