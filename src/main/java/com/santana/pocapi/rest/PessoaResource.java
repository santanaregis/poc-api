package com.santana.pocapi.rest;

import com.santana.pocapi.service.PessoaService;
import com.santana.pocapi.service.dto.PessoaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<PessoaDTO> createPessoa(@RequestBody PessoaDTO pessoaDTO) throws Exception {
        if (pessoaDTO.getId() != null) {
            throw new Exception("A new pessoa cannot already have an ID "+ENTITY_NAME+" idexists");
        }
        PessoaDTO result = pessoaService.save(pessoaDTO);
        return ResponseEntity.ok(result);
    }

    /**
     * PUT  /pessoa : Updates an existing pessoa.
     *
     * @param pessoaDTO the pessoaDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated pessoaDTO,
     * or with status 400 (Bad Request) if the pessoaDTO is not valid,
     * or with status 500 (Internal Server Error) if the pessoaDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pessoa")
    public ResponseEntity<PessoaDTO> updatePessoa(@RequestBody PessoaDTO pessoaDTO) throws Exception {
        if (pessoaDTO.getId() == null) {
            throw new Exception("Invalid id "+ENTITY_NAME+" idnull");
        }
        PessoaDTO result = pessoaService.save(pessoaDTO);
        return ResponseEntity.ok(result);

    }

    /**
     * GET  /pessoa : get all the pessoas.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of pessoas in body
     */
    @GetMapping("/pessoa")
    public ResponseEntity<List<PessoaDTO>> getAllPessoas() {
        return ResponseEntity.ok(pessoaService.findAll());
    }

    /**
     * GET  /pessoa/:id : get the "id" pessoa.
     *
     * @param id the id of the pessoaDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the pessoaDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pessoa/{id}")
    public ResponseEntity<PessoaDTO> getPessoa(@PathVariable Long id) {
        Optional<PessoaDTO> pessoaDTO = pessoaService.findOne(id);
        return ResponseEntity.ok(pessoaDTO.get());
    }

    /**
     * DELETE  /pessoa/:id : delete the "id" pessoa.
     *
     * @param id the id of the pessoaDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity<?> deletePessoa(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
