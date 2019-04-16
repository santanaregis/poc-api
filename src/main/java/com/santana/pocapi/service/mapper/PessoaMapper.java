package com.santana.pocapi.service.mapper;

import com.santana.pocapi.model.Pessoa;
import com.santana.pocapi.service.dto.PessoaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class, ProfissaoMapper.class})
public interface PessoaMapper extends EntityMapper<PessoaDTO, Pessoa> {

    PessoaDTO toDto(Pessoa produto);

    Pessoa toEntity(PessoaDTO produtoDTO);

    default Pessoa fromId(Long id) {
        if (id == null) {
            return null;
        }
        Pessoa produto = new Pessoa();
        produto.setId(id);
        return produto;
    }
}
