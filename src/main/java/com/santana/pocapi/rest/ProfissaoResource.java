package com.santana.pocapi.rest;

import com.santana.pocapi.service.ProfissaoService;
import com.santana.pocapi.service.dto.ProfissaoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfissaoResource {

    private final ProfissaoService profissaoService;
    private static final String ENTITY_NAME = "ProfissaoResource";

    public ProfissaoResource(ProfissaoService profissaoService) {
        this.profissaoService = profissaoService;
    }


    /**
     * POST  /profissao : Create a new profissao.
     *
     * @param profissaoDTO the profissaoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new profissaoDTO, or with status 400 (Bad Request) if the profissao has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/profissao")
    public ResponseEntity<ProfissaoDTO> createProfissao(@RequestBody ProfissaoDTO profissaoDTO) throws Exception {
        if (profissaoDTO.getId() != null) {
            throw new Exception("A new profissao cannot already have an ID "+ENTITY_NAME+" idexists");
        }
        ProfissaoDTO result = profissaoService.save(profissaoDTO);
        return ResponseEntity.ok(result);
    }

    /**
     * PUT  /profissao : Updates an existing profissao.
     *
     * @param profissaoDTO the profissaoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated profissaoDTO,
     * or with status 400 (Bad Request) if the profissaoDTO is not valid,
     * or with status 500 (Internal Server Error) if the profissaoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/profissao")
    public ResponseEntity<ProfissaoDTO> updateProfissao(@RequestBody ProfissaoDTO profissaoDTO) throws Exception {
        if (profissaoDTO.getId() == null) {
            throw new Exception("Invalid id "+ENTITY_NAME+" idnull");
        }
        ProfissaoDTO result = profissaoService.save(profissaoDTO);
        return ResponseEntity.ok(result);

    }

    /**
     * GET  /profissao : get all the profissoes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of profissao in body
     */
    @GetMapping("/profissao")
    public ResponseEntity<List<ProfissaoDTO>> getAllProfissoes() {
        return ResponseEntity.ok(profissaoService.findAll());
    }

    /**
     * GET  /profissao/:id : get the "id" profissao.
     *
     * @param id the id of the profissaoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the profissaoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/profissao/{id}")
    public ResponseEntity<ProfissaoDTO> getPessoa(@PathVariable Long id) {
        Optional<ProfissaoDTO> profissaoDTO = profissaoService.findOne(id);
        return ResponseEntity.ok(profissaoDTO.get());
    }

    /**
     * DELETE  /profissao/:id : delete the "id" profissao.
     *
     * @param id the id of the profissaoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/profissao/{id}")
    public ResponseEntity<?> deleteProfissao(@PathVariable Long id) {
        profissaoService.delete(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
