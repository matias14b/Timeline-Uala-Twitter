package com.ejercicio.uala.timeline.service;

import com.ejercicio.uala.timeline.builder.mockWebService.TweetMockWebService;
import com.ejercicio.uala.timeline.builder.mockWebService.UsuarioMockWebService;
import com.ejercicio.uala.timeline.dto.TimeLineDTO;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TimeLineServiceImplTest {
    @Autowired
    private TimeLineService timeLineService;

    @Value("${uala.twitter.servicio.tweet}")
    private int apiUrlServicioTweet;

    @Value("${uala.twitter.servicio.usuario}")
    private String apiUrlServicioUsuario;

    @Test
    public void obtener_conUsuarioValidoConUnUsuarioSeguidoPosicionPaginaCeroYCantidadDeTweetsDosOrdenadoAsc_RetornaTimelineConDosTweetsOrdenadoAscendenteDelUsuarioSeguido() throws IOException, JSONException {
        Long id = 1L;

        try (MockWebServer mockWebServer = UsuarioMockWebService.conPeticion(apiUrlServicioUsuario).conUsuarioConSeguidoresValidos().mock()) {
            try (MockWebServer mockWebServerTweet = TweetMockWebService.conPeticion(apiUrlServicioTweet).conDosTweetsPaginaCeroOrdenadoFechaCreacionAsc().mock()) {
                TimeLineDTO timeLineDTO = timeLineService.obtenerTimeLinePorUsuarioId(id, 0, 1, "fechaCreacion,asc");
                assertThat(timeLineDTO).isNotNull();
                assertThat(timeLineDTO.getUsername()).isEqualTo("ichiban");
                assertThat(timeLineDTO.getUsuarioId()).isEqualTo(id);
                assertThat(timeLineDTO.getTweets().get(0).getId()).isEqualTo(49);
                assertThat(timeLineDTO.getTweets().get(0).getMensaje()).isEqualTo("Tweet de Namba");
                assertThat(timeLineDTO.getTweets().get(0).getUsuarioCreadorId()).isEqualTo(3);
            }
        }
    }

}
