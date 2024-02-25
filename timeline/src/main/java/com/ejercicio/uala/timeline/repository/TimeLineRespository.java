package com.ejercicio.uala.timeline.repository;

import com.ejercicio.uala.timeline.dto.TweetDTO;
import com.ejercicio.uala.timeline.dto.UsuarioDTO;

import java.util.List;


public interface TimeLineRespository {

    List<TweetDTO> obtenerTweetsDeUsuariosSeguidoPorUsuarioId(Long id, int pagina, long tamanio, String sort);

    UsuarioDTO obtenerUsuario(Long id);

}
