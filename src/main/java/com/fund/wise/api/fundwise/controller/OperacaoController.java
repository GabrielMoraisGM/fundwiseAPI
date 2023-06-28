package com.fund.wise.api.fundwise.controller;

import com.fund.wise.api.fundwise.dto.ativo.AtivoViewDto;
import com.fund.wise.api.fundwise.dto.operacao.OperacaoDto;
import com.fund.wise.api.fundwise.dto.operacao.OperacaoViewDto;
import com.fund.wise.api.fundwise.model.Operacao;
import com.fund.wise.api.fundwise.model.enumerated.EnumTipoOperacao;
import com.fund.wise.api.fundwise.service.imp.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operacao")
public class OperacaoController {

    @Autowired
    OperacaoService operacaoService;

    @PostMapping
    public ResponseEntity<OperacaoViewDto> cadastrarOperacao(OperacaoDto novaOperacao){

        Operacao operacaoSalva = operacaoService.salvarOperacao(novaOperacao.toEntity());

        OperacaoViewDto operacaoView = new OperacaoViewDto(
                operacaoSalva.getCodigoOperacao(),
                EnumTipoOperacao.getValue(operacaoSalva.getTipoOperacao()),
                operacaoSalva.getValor(),
                operacaoSalva.getAtivos(),
                operacaoSalva.getIdOperacao()
        );

        return ResponseEntity.ok(operacaoView);
    }
}
