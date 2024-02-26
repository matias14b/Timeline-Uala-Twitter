package com.ejercicio.uala.timeline.service;

import com.ejercicio.uala.timeline.dto.TimeLineDTO;
import com.ejercicio.uala.timeline.dto.TweetDTO;
import com.ejercicio.uala.timeline.dto.UsuarioDTO;
import com.ejercicio.uala.timeline.repository.TimeLineRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeLineServiceImpl implements TimeLineService {

    private final TimeLineRepositoryImpl timeLineRepository;

    @Override
    public TimeLineDTO obtenerTimeLinePorUsuarioId(Long idUsuario, int pagina, long tamanio, String sort) {
        UsuarioDTO usuario = timeLineRepository.obtenerUsuario(idUsuario);
        List<TweetDTO> tweets = timeLineRepository.obtenerTimeLinePorUsuarioId(idUsuario, pagina, tamanio, sort);
        TimeLineDTO timeline = new TimeLineDTO();

        timeline.setUsuarioId(usuario.getId());
        timeline.setUsername(usuario.getUsername());
        timeline.setTweets(tweets);

        return timeline;
    }
}
