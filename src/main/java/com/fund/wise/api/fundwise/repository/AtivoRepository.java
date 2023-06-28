package com.fund.wise.api.fundwise.repository;

import com.fund.wise.api.fundwise.model.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long> {
}
