package com.santana.pocapi.service;

import com.santana.pocapi.service.dto.ProfissaoDTO;

import java.util.List;
import java.util.Optional;

public interface ProfissaoService {

    /**
     * Save a profissao.
     *
     * @param profissaoDTO the entity to save
     * @return the persisted entity
     */
    ProfissaoDTO save(ProfissaoDTO profissaoDTO);

    /**
     * Get all the profissoes.
     *
     * @return the list of entities
     */
    List<ProfissaoDTO> findAll();

    /**
     * Get the "id" profissao.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ProfissaoDTO> findOne(Long id);

    /**
     * Delete the "id" profissao.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

}
