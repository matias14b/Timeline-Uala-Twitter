package com.ejercicio.uala.timeline.repository;

import com.ejercicio.uala.timeline.dto.TweetDTO;
import com.ejercicio.uala.timeline.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;

@Repository
public class TimeLineRepositoryImpl implements TimeLineRespository {

    @Value("${uala.twitter.servicio.tweet}")
    private String puertoTweet;
    @Value("${uala.twitter.servicio.usuario}")
    private String puertoUsuario;

    private String urlBase = "http://localhost:";
    private final RestClient restClient = RestClient.create();

    @Override
    @Cacheable("obtenerTweetsDeUsuariosSeguidoPorUsuarioId")
    public List<TweetDTO> obtenerTimeLinePorUsuarioId(Long id, int pagina, long tamanio, String sort) {
        return restClient.method(HttpMethod.GET)
                .uri(urlBase + puertoTweet + "/api/" + id + "/tweets/?page=" + pagina + "&size=" + tamanio + "&sort=" + sort)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public UsuarioDTO obtenerUsuario(Long id) {
        return restClient.method(HttpMethod.GET)
                .uri(urlBase + puertoUsuario + "/api/usuario/" + id + "/seguidos")
                .retrieve()
                .body(UsuarioDTO.class);
    }
}
