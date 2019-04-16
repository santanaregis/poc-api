package com.santana.pocapi.service.mapper;

import java.util.Set;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */

public interface EntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    Set <E> toEntity(Set<D> dtoList);

    Set<D> toDto(Set<E> entityList);
}
