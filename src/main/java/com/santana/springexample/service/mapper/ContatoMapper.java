package com.santana.springexample.service.mapper;

import com.santana.springexample.model.Contato;
import com.santana.springexample.service.dto.ContatoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ContatoMapper extends EntityMapper<ContatoDTO, Contato> {

    ContatoDTO toDto(Contato contato);

    Contato toEntity(ContatoDTO contatoDTO);

    default Contato fromId(Long id) {
        if (id == null) {
            return null;
        }
        Contato contato = new Contato();
        contato.setId(id);
        return contato;
    }
}