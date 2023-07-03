package com.fund.wise.api.fundwise.controller;

import com.fund.wise.api.fundwise.dto.ativo.AtivoDto;
import com.fund.wise.api.fundwise.model.Ativo;
import com.fund.wise.api.fundwise.service.imp.AtivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ativo")
public class AtivoController {

    @Autowired
    AtivoService ativoService;

    @PostMapping
    public ResponseEntity<Ativo> salvarAtivo(AtivoDto novoAtivo){
        return ResponseEntity.status(HttpStatus.CREATED).body(ativoService.salvarAtivo(novoAtivo.toEntity()));
    }

    @GetMapping("{id}")
    public ResponseEntity<Ativo> pesquisarAtivoPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(ativoService.pesquisarAtivoPorId(id));
    }

    @DeleteMapping("{id}")
    public HttpStatus deletarAtivoPorId(@RequestParam Long id){
        ativoService.deletarAtivoPorId(id);
        return HttpStatus.ACCEPTED;
    }

    @PatchMapping
    public ResponseEntity<Ativo> atualizarAtivo(Ativo ativoAtualizado){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ativoService.atualizarAtivo(ativoAtualizado));
    }
}
