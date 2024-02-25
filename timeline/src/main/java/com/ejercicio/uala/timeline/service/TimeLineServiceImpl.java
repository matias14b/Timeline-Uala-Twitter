package com.ejercicio.uala.timeline.service;

import com.ejercicio.uala.timeline.dto.TimeLineDTO;
import com.ejercicio.uala.timeline.dto.TweetDTO;
import com.ejercicio.uala.timeline.dto.UsuarioDTO;
import com.ejercicio.uala.timeline.repository.TimeLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeLineServiceImpl implements TimeLineService{

    private final TimeLineRepository timeLineRepository;
    @Override
    public TimeLineDTO obtenerPorUsuarioIdFiltradoPosicionPaginaYCantidadDeTweets(long idUsuario, int posicionDePagina, int cantidadDeTweets) {
        UsuarioDTO usuario = timeLineRepository.obtenerUsuario(idUsuario);
        List<TweetDTO> tweets = timeLineRepository.iniciarSesion(usuario.getSeguidosId(), posicionDePagina, cantidadDeTweets);
        TimeLineDTO timeline = new TimeLineDTO();

        timeline.setUsuarioId(usuario.getId());
        timeline.setUsername(usuario.getUsername());
        timeline.setTweets(tweets);

        return timeline;
    }
}
