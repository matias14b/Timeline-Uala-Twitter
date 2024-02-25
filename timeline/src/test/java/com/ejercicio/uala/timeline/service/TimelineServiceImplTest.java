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
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TimelineServiceImplTest {

    @Value("${uala.twitter.servicio.usuario}")
    private String apiUrlServicioUsuario;

    @Value("${uala.twitter.servicio.tweet}")
    private String apiUrlServicioTweet;

    @Autowired
    private TimeLineServiceImpl timelineServiceImpl;

    @Test
    public void obtener_conUsuarioValidoConUnUsuarioSeguidoPosicionPaginaUnoYCantidadDeTweetsUno_RetornaTimelineConUnTweetDelUsuarioSeguido() throws IOException, JSONException {
        String username = "ichiban";
        Long id = 1L;
        TimeLineDTO timeLineDTO = new TimeLineDTO();

        try (MockWebServer mockWebServer = UsuarioMockWebService.conPeticion(apiUrlServicioUsuario).conUsuarioConSeguidoresValidos(id, username, Arrays.asList(1L, 2L, 3L, 4L, 5L)).mock()) {
            try (MockWebServer mockWebServerTweet = TweetMockWebService.conPeticion(apiUrlServicioTweet).conTweetsValidos().mock()) {
                timeLineDTO = timelineServiceImpl.obtenerPorUsuarioIdFiltradoPosicionPaginaYCantidadDeTweets(1, 1, 1);
                assertThat(timeLineDTO).isNotNull();
                assertThat(timeLineDTO.getUsername()).isEqualTo("ichiban");
                assertThat(timeLineDTO.getUsuarioId()).isEqualTo(id);
                assertThat(timeLineDTO.getTweets()).isNotEmpty();
            }
        }



    }

}
