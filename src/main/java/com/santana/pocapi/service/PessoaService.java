package com.santana.pocapi.service;

import com.santana.pocapi.service.dto.PessoaDTO;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    /**
     * Save a produto.
     *
     * @param produtoDTO the entity to save
     * @return the persisted entity
     */
    PessoaDTO save(PessoaDTO produtoDTO);

    /**
     * Get all the produtos.
     *
     * @return the list of entities
     */
    List<PessoaDTO> findAll();

    /**
     * Get the "id" produto.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<PessoaDTO> findOne(Long id);

    /**
     * Delete the "id" produto.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

}
