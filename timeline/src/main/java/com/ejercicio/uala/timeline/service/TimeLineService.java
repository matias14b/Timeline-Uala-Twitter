package com.ejercicio.uala.timeline.service;

import com.ejercicio.uala.timeline.dto.TimeLineDTO;

public interface TimeLineService {
    TimeLineDTO obtenerTimeLinePorUsuarioId(Long id, int pagina, long tamanio, String sort);
}
