package com.santana.pocapi.service.impl;

import com.santana.pocapi.model.Profissao;
import com.santana.pocapi.repository.ProfissaoRepository;
import com.santana.pocapi.service.ProfissaoService;
import com.santana.pocapi.service.dto.ProfissaoDTO;
import com.santana.pocapi.service.mapper.ProfissaoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ProfissaoServiceImpl implements ProfissaoService {

    private static Logger log = LoggerFactory.getLogger(ProfissaoServiceImpl.class);

    private final ProfissaoRepository profissaoRepository;
    private final ProfissaoMapper profissaoMapper;

    public ProfissaoServiceImpl(ProfissaoRepository profissaoRepository, ProfissaoMapper profissaoMapper) {
        this.profissaoRepository = profissaoRepository;
        this.profissaoMapper = profissaoMapper;
    }

    /**
     * Save a profissao.
     *
     * @param profissaoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProfissaoDTO save(ProfissaoDTO profissaoDTO) {
        log.debug("Request to save Profissao : {}", profissaoDTO);
        Profissao profissao = profissaoMapper.toEntity(profissaoDTO);
        profissao = profissaoRepository.save(profissao);
        return profissaoMapper.toDto(profissao);
    }

    /**
     * Get all the profissoes.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProfissaoDTO> findAll() {
        log.debug("Request to get all Pessoa");
        return StreamSupport
                .stream(profissaoRepository.findAll().spliterator(), false)
                .map(profissaoMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one profissao by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProfissaoDTO> findOne(Long id) {
        log.debug("Request to get Profissao : {}", id);
        return profissaoRepository.findById(id)
                .map(profissaoMapper::toDto);
    }

    /**
     * Delete the profissao by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Profissao : {}", id);
        profissaoRepository.deleteById(id);
    }

}
