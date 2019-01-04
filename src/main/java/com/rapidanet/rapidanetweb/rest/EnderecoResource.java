package com.rapidanet.rapidanetweb.rest;

import com.rapidanet.rapidanetweb.rest.util.HeaderUtil;
import com.rapidanet.rapidanetweb.rest.util.PaginationUtil;
import com.rapidanet.rapidanetweb.service.EnderecoService;
import com.rapidanet.rapidanetweb.service.PessoaService;
import com.rapidanet.rapidanetweb.service.dto.EnderecoDTO;
import com.rapidanet.rapidanetweb.service.dto.PessoaDTO;
import org.apache.tomcat.util.http.ResponseUtil;
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
     * PUT  /endereco : Updates an existing pessoa.
     *
     * @param enderecoDTO the enderecoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated enderecoDTO,
     * or with status 400 (Bad Request) if the enderecoDTO is not valid,
     * or with status 500 (Internal Server Error) if the enderecoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/endereco")
    public ResponseEntity<EnderecoDTO> updatePessoa(@RequestBody EnderecoDTO enderecoDTO) throws Exception {
        if (enderecoDTO.getId() == null) {
            throw new Exception("Invalid id "+ENTITY_NAME+" idnull");
        }
        EnderecoDTO result = enderecoService.save(enderecoDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, enderecoDTO.getId().toString()))
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

    /**
     * DELETE  /endereco/:id : delete the "id" endereco.
     *
     * @param id the id of the enderecoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/endereco/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }


}
