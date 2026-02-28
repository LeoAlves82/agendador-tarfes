package com.ms.agendadortarefas.business;

import com.ms.agendadortarefas.business.dto.TarefasDTO;
import com.ms.agendadortarefas.business.mapper.TarefasConverter;
import com.ms.agendadortarefas.infraestructure.entity.TarefasEntity;
import com.ms.agendadortarefas.infraestructure.enums.StatusNotificacaoEnum;
import com.ms.agendadortarefas.infraestructure.repository.TarefasRepository;
import com.ms.agendadortarefas.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasSevice {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
}
