package com.rapidanet.rapidanetweb.repository;

import com.rapidanet.rapidanetweb.model.Contato;
import com.rapidanet.rapidanetweb.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
