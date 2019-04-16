package com.santana.pocapi.service.mapper;

import com.santana.pocapi.model.Produto;
import com.santana.pocapi.service.dto.ProdutoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProdutoMapper extends EntityMapper<ProdutoDTO, Produto> {

    ProdutoDTO toDto(Produto produto);

    Produto toEntity(ProdutoDTO produtoDTO);

    default Produto fromId(Long id) {
        if (id == null) {
            return null;
        }
        Produto produto = new Produto();
        produto.setId(id);
        return produto;
    }
}
