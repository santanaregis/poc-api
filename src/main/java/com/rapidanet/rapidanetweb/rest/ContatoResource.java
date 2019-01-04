package com.rapidanet.rapidanetweb.rest;

import com.rapidanet.rapidanetweb.rest.util.HeaderUtil;
import com.rapidanet.rapidanetweb.service.ContatoService;
import com.rapidanet.rapidanetweb.service.EnderecoService;
import com.rapidanet.rapidanetweb.service.dto.ContatoDTO;
import com.rapidanet.rapidanetweb.service.dto.EnderecoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoResource {

    private final ContatoService contatoService;
    private static final String ENTITY_NAME = "ContatoResource";

    public ContatoResource(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    /**
     * POST  /contato : Create a new endereco.
     *
     * @param contatoDTO the enderecoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new enderecoDTO, or with status 400 (Bad Request) if the pessoa has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/contato")
    public ResponseEntity<ContatoDTO> createContato(@RequestBody ContatoDTO contatoDTO) throws Exception {
        ContatoDTO result = contatoService.save(contatoDTO);
        return ResponseEntity.created(new URI("/api/contato/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * DELETE  /contato/:id : delete the "id" contato.
     *
     * @param id the id of the contatoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bolsas/{id}")
    public ResponseEntity<Void> deleteContato(@PathVariable Long id) {
        contatoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}