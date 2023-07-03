package com.fund.wise.api.fundwise.controller;

import com.fund.wise.api.fundwise.dto.operacao.OperacaoDto;
import com.fund.wise.api.fundwise.dto.operacao.OperacaoEditarDto;
import com.fund.wise.api.fundwise.dto.operacao.OperacaoViewDto;
import com.fund.wise.api.fundwise.model.Operacao;
import com.fund.wise.api.fundwise.model.enumerated.EnumTipoOperacao;
import com.fund.wise.api.fundwise.service.imp.OperacaoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operacao")
public class OperacaoController {

    @Autowired
    OperacaoService operacaoService;

    @PostMapping
    public ResponseEntity<OperacaoViewDto> cadastrarOperacao(OperacaoDto novaOperacao){

        Operacao operacaoSalva = operacaoService.salvarOperacao(novaOperacao.toEntity());

        //utiliza o metodo builder para contruir o view com base nos dados salvos
        OperacaoViewDto operacaoView = operacaoViewBuilder(operacaoSalva);

        return ResponseEntity.ok(operacaoView);
    }

    @GetMapping("{id}")
    public ResponseEntity<OperacaoViewDto> pesquisarOperacaoPorId(@RequestParam Long id){

        Operacao operacaoDb = operacaoService.pesquisarOperacaoPorId(id);

        OperacaoViewDto operacaoView = operacaoViewBuilder(operacaoDb);

        return ResponseEntity.status(HttpStatus.FOUND).body(operacaoView);
    }

    @DeleteMapping("{id}")
    public HttpStatus deletarOperacaoPorId(@RequestParam Long id){

        operacaoService.deletarOperacaoPorId(id);

        return HttpStatus.ACCEPTED;
    }

    @PatchMapping
    public ResponseEntity<OperacaoViewDto> atualizarOperacaoPorId(OperacaoEditarDto operacaoAtualizada){
        //salva operacao atualizada no BD
        Operacao operacaoSalva = operacaoService.atualizarOperacaoPorId(operacaoAtualizada.toEntity());
        //monta uma view com a nova operacao
        OperacaoViewDto operacaoView = operacaoViewBuilder(operacaoSalva);
        //retorna a entidade view
        return ResponseEntity.status(HttpStatus.OK).body(operacaoView);
    }

    private OperacaoViewDto operacaoViewBuilder(Operacao operacaoSalva){

        OperacaoViewDto operacaoView = new OperacaoViewDto(
                operacaoSalva.getCodigoOperacao(),
                EnumTipoOperacao.getValue(operacaoSalva.getTipoOperacao()),
                operacaoSalva.getValor(),
                operacaoSalva.getAtivos(),
                operacaoSalva.getIdOperacao()
        );

        return operacaoView;
    }
}
