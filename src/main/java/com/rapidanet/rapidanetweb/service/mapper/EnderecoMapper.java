package com.rapidanet.rapidanetweb.service.mapper;

import com.rapidanet.rapidanetweb.model.Endereco;
import com.rapidanet.rapidanetweb.model.Pessoa;
import com.rapidanet.rapidanetweb.service.dto.EnderecoDTO;
import com.rapidanet.rapidanetweb.service.dto.PessoaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface EnderecoMapper extends EntityMapper<EnderecoDTO, Endereco> {

    EnderecoDTO toDto(Endereco endereco);

    Endereco toEntity(EnderecoDTO enderecoDTO);

    default Endereco fromId(Long id) {
        if (id == null) {
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setId(id);
        return endereco;
    }
}
