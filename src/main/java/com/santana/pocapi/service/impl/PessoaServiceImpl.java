package com.santana.pocapi.service.impl;

import com.santana.pocapi.model.Pessoa;
import com.santana.pocapi.repository.PessoaRepository;
import com.santana.pocapi.service.PessoaService;
import com.santana.pocapi.service.dto.PessoaDTO;
import com.santana.pocapi.service.mapper.PessoaMapper;
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
public class PessoaServiceImpl implements PessoaService {

    private static Logger log = LoggerFactory.getLogger(PessoaServiceImpl.class);

    private final PessoaRepository produtoRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaServiceImpl(PessoaRepository produtoRepository, PessoaMapper pessoaMapper) {
        this.produtoRepository = produtoRepository;
        this.pessoaMapper = pessoaMapper;
    }

    /**
     * Save a produto.
     *
     * @param produtoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PessoaDTO save(PessoaDTO produtoDTO) {
        log.debug("Request to save Pessoa : {}", produtoDTO);
        Pessoa produto = pessoaMapper.toEntity(produtoDTO);
        produto = produtoRepository.save(produto);
        return pessoaMapper.toDto(produto);
    }

    /**
     * Get all the Pessoa.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PessoaDTO> findAll() {
        log.debug("Request to get all Pessoa");
        return StreamSupport
                .stream(produtoRepository.findAll().spliterator(), false)
                .map(pessoaMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one produto by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PessoaDTO> findOne(Long id) {
        log.debug("Request to get Pessoa : {}", id);
        return produtoRepository.findById(id)
                .map(pessoaMapper::toDto);
    }

    /**
     * Delete the produto by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Pessoa : {}", id);
        produtoRepository.deleteById(id);
    }

}
