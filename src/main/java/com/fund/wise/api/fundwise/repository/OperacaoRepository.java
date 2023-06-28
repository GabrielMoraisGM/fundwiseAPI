package com.fund.wise.api.fundwise.repository;

import com.fund.wise.api.fundwise.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
}
