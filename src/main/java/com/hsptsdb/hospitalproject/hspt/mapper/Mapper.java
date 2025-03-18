package com.hsptsdb.hospitalproject.hspt.mapper;

import com.hsptsdb.hospitalproject.hspt.dto.GenericDTO;
import com.hsptsdb.hospitalproject.hspt.model.GenericModel;

import java.util.List;

public interface Mapper<E extends GenericModel, D extends GenericDTO> {
    E toEntity(D dto);
    D toDTO(E entity); //
    List<E> toEntities(List<D> dtos);
    List<D> toDTOs(List<E> entities);
}
