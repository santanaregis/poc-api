package com.santana.pocapi.repository;

import com.santana.pocapi.model.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {

}
