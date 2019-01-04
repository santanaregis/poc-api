package com.rapidanet.rapidanetweb.repository;

import com.rapidanet.rapidanetweb.model.Endereco;
import com.rapidanet.rapidanetweb.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
