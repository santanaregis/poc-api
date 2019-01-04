package com.rapidanet.rapidanetweb.service.mapper;

import com.rapidanet.rapidanetweb.model.Contato;
import com.rapidanet.rapidanetweb.model.Endereco;
import com.rapidanet.rapidanetweb.service.dto.ContatoDTO;
import com.rapidanet.rapidanetweb.service.dto.EnderecoDTO;
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
