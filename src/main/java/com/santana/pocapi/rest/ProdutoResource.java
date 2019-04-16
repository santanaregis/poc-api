package com.santana.pocapi.rest;

import com.santana.pocapi.service.ProdutoService;
import com.santana.pocapi.service.dto.ProdutoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProdutoResource {

    private final ProdutoService produtoService;
    private static final String ENTITY_NAME = "ProdutoResource";

    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    /**
     * POST  /produto : Create a new produto.
     *
     * @param produtoDTO the produtoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new produtoDTO, or with status 400 (Bad Request) if the produto has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/produto")
    public ResponseEntity<ProdutoDTO> createProduto(@RequestBody ProdutoDTO produtoDTO) throws Exception {
        if (produtoDTO.getId() != null) {
            throw new Exception("A new produto cannot already have an ID "+ENTITY_NAME+" idexists");
        }
        ProdutoDTO result = produtoService.save(produtoDTO);
        return ResponseEntity.ok(result);
    }

    /**
     * PUT  /produto : Updates an existing produto.
     *
     * @param produtoDTO the produtoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated produtoDTO,
     * or with status 400 (Bad Request) if the produtoDTO is not valid,
     * or with status 500 (Internal Server Error) if the produtoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/produto")
    public ResponseEntity<ProdutoDTO> updateProduto(@RequestBody ProdutoDTO produtoDTO) throws Exception {
        if (produtoDTO.getId() == null) {
            throw new Exception("Invalid id "+ENTITY_NAME+" idnull");
        }
        ProdutoDTO result = produtoService.save(produtoDTO);
        return ResponseEntity.ok(result);

    }

    /**
     * GET  /produto : get all the produtos.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of produtos in body
     */
    @GetMapping("/produto")
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    /**
     * GET  /produto/:id : get the "id" produto.
     *
     * @param id the id of the produtoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the produtoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/produto/{id}")
    public ResponseEntity<ProdutoDTO> getProduto(@PathVariable Long id) {
        Optional<ProdutoDTO> produtoDTO = produtoService.findOne(id);
        return ResponseEntity.ok(produtoDTO.get());
    }

    /**
     * DELETE  /produto/:id : delete the "id" produto.
     *
     * @param id the id of the produtoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
