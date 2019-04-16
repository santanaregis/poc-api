package com.santana.pocapi.service.mapper;

import com.santana.pocapi.model.Profissao;
import com.santana.pocapi.service.dto.ProfissaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProfissaoMapper extends EntityMapper<ProfissaoDTO, Profissao> {

    ProfissaoDTO toDto(Profissao profissao);

    Profissao toEntity(ProfissaoDTO profissaoDTO);

    default Profissao fromId(Long id) {
        if (id == null) {
            return null;
        }
        Profissao profissao = new Profissao();
        profissao.setId(id);
        return profissao;
    }
}
