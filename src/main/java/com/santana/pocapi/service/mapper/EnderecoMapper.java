package com.santana.pocapi.service.mapper;

import com.santana.pocapi.model.Endereco;
import com.santana.pocapi.service.dto.EnderecoDTO;
import org.mapstruct.Mapper;

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
