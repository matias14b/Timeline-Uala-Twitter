package com.ejercicio.uala.timeline.service;

import com.ejercicio.uala.timeline.dto.TimeLineDTO;

public interface TimeLineService {
    TimeLineDTO obtenerPorUsuarioIdFiltradoPosicionPaginaYCantidadDeTweets(long idUsuario, int posicionDePagina, int cantidadDeTweets);
}
