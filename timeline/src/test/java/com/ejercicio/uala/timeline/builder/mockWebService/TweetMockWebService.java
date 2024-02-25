package com.ejercicio.uala.timeline.builder.mockWebService;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TweetMockWebService {

    private int puerto;

    private List<MockResponse> respuestas;

    public static TweetMockWebService conPeticion(String puerto) throws IOException {
        TweetMockWebService instance = new TweetMockWebService();
        instance.puerto = Integer.parseInt(puerto);
        instance.respuestas = new ArrayList<>();
        return instance;
    }

    public TweetMockWebService conTweetsValidos() throws JSONException {
        MockResponse respuesta = new MockResponse()
                .setResponseCode(HttpStatus.OK.value())
                .setBody(new JSONArray("[\n" +
                        "{\n" +
                        "\"id\":9,\n" +
                        "\"mensaje\":\"Hola\",\n" +
                        "\"usuarioCreadorId\":1,\n" +
                        "\"fechaCreacion\":\"24/02/2024 04:46\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\":10,\n" +
                        "\"mensaje\":\"Hola\",\n" +
                        "\"usuarioCreadorId\":1,\n" +
                        "\"fechaCreacion\":\"24/02/2024 04:46\"\n" +
                        "}\n" +
                        "]").toString())
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        this.respuestas.add(respuesta);
        return this;
    }

    public MockWebServer mock() throws IOException {
        MockWebServer mockWebServer = new MockWebServer();
        mockWebServer.start(this.puerto);
        this.respuestas.forEach(mockWebServer::enqueue);
        return mockWebServer;
    }
}
