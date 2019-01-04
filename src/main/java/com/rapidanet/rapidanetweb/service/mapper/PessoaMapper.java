package com.rapidanet.rapidanetweb.service.mapper;

import com.rapidanet.rapidanetweb.model.Pessoa;
import com.rapidanet.rapidanetweb.service.dto.PessoaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class, ContatoMapper.class})
public interface PessoaMapper extends EntityMapper<PessoaDTO, Pessoa> {

    PessoaDTO toDto(Pessoa pessoa);

    Pessoa toEntity(PessoaDTO pessoaDTO);

    default Pessoa fromId(Long id) {
        if (id == null) {
            return null;
        }
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        return pessoa;
    }
}
