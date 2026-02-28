package com.ms.agendadortarefas.business.mapper;

import com.ms.agendadortarefas.business.dto.TarefasDTO;
import com.ms.agendadortarefas.infraestructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {
    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
