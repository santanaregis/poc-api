package com.rapidanet.rapidanetweb.rest;

import com.rapidanet.rapidanetweb.rest.util.HeaderUtil;
import com.rapidanet.rapidanetweb.rest.util.PaginationUtil;
import com.rapidanet.rapidanetweb.service.EnderecoService;
import com.rapidanet.rapidanetweb.service.PessoaService;
import com.rapidanet.rapidanetweb.service.dto.EnderecoDTO;
import com.rapidanet.rapidanetweb.service.dto.PessoaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EnderecoResource {

    private final EnderecoService enderecoService;
    private static final String ENTITY_NAME = "EnderecoResource";

    public EnderecoResource(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    /**
     * POST  /endereco : Create a new endereco.
     *
     * @param enderecoDTO the enderecoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new enderecoDTO, or with status 400 (Bad Request) if the pessoa has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/endereco")
    public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) throws URISyntaxException, Exception {
//        log.debug("REST request to save Pessoa : {}", pessoaDTO);

        EnderecoDTO result = enderecoService.save(enderecoDTO);
        return ResponseEntity.created(new URI("/api/endereco/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * GET  /endereco : get all the enderecos.
     *
     * @param filter the filter of the request
     * @return the list of enderecos in body
     */
    @GetMapping("/endereco")
    public List<EnderecoDTO> getAllEnderecos(@RequestParam(required = false) String filter) {
        List<EnderecoDTO> enderecos = enderecoService.findAll();
        return enderecos;
    }

}
