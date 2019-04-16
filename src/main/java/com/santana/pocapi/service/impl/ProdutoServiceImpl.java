package com.santana.pocapi.service.impl;

import com.santana.pocapi.model.Produto;
import com.santana.pocapi.repository.ProdutoRepository;
import com.santana.pocapi.service.ProdutoService;
import com.santana.pocapi.service.dto.ProdutoDTO;
import com.santana.pocapi.service.mapper.ProdutoMapper;
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
public class ProdutoServiceImpl implements ProdutoService {

    private static Logger log = LoggerFactory.getLogger(ProdutoServiceImpl.class);

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    /**
     * Save a produto.
     *
     * @param produtoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        log.debug("Request to save Profissao : {}", produtoDTO);
        Produto produto = produtoMapper.toEntity(produtoDTO);
        produto = produtoRepository.save(produto);
        return produtoMapper.toDto(produto);
    }

    /**
     * Get all the produtos.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAll() {
        log.debug("Request to get all Produto");
        return StreamSupport
                .stream(produtoRepository.findAll().spliterator(), false)
                .map(produtoMapper::toDto)
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
    public Optional<ProdutoDTO> findOne(Long id) {
        log.debug("Request to get Produto : {}", id);
        return produtoRepository.findById(id)
                .map(produtoMapper::toDto);
    }

    /**
     * Delete the produto by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Produto : {}", id);
        produtoRepository.deleteById(id);
    }

}
