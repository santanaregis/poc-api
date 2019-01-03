package com.rapidanet.rapidanetweb.rest;

import com.rapidanet.rapidanetweb.rest.util.HeaderUtil;
import com.rapidanet.rapidanetweb.rest.util.PaginationUtil;
import com.rapidanet.rapidanetweb.service.PessoaService;
import com.rapidanet.rapidanetweb.service.dto.PessoaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaResource {

    private final PessoaService pessoaService;
    private static final String ENTITY_NAME = "PessoaResource";

    public PessoaResource(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }


    /**
     * POST  /pessoa : Create a new pessoa.
     *
     * @param pessoaDTO the pessoaDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new pessoaDTO, or with status 400 (Bad Request) if the pessoa has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pessoa")
    public ResponseEntity<PessoaDTO> createPessoa(@RequestBody PessoaDTO pessoaDTO) throws URISyntaxException, Exception {
//        log.debug("REST request to save Pessoa : {}", pessoaDTO);
        if (pessoaDTO.getId() != null) {
            //throw new BadRequestAlertException("A new pessoa cannot already have an ID", ENTITY_NAME ,"idexists");
        }
        PessoaDTO result = pessoaService.save(pessoaDTO);
        return ResponseEntity.created(new URI("/api/bolsas/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * GET  /pessoa : get all the pessoas.
     *
     * @param pageable the pagination information
     * @param filter the filter of the request
     * @return the ResponseEntity with status 200 (OK) and the list of pessoas in body
     */
    @GetMapping("/pessoa")
    public ResponseEntity<List<PessoaDTO>> getAllBolsas(Pageable pageable, @RequestParam(required = false) String filter) {
        Page<PessoaDTO> page = pessoaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pessoa");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

}
