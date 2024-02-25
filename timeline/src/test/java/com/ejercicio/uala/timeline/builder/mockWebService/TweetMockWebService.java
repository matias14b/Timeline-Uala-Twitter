package com.ejercicio.uala.timeline.builder.mockWebService;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TweetMockWebService {

    private int puerto;

    private List<MockResponse> respuestas;

    public static TweetMockWebService conPeticion(int puerto) throws IOException {
        TweetMockWebService instance = new TweetMockWebService();
        instance.puerto = puerto;
        instance.respuestas = new ArrayList<>();
        return instance;
    }

    public TweetMockWebService conDosTweetsPaginaCeroOrdenadoFechaCreacionAsc() throws JSONException {
        MockResponse respuesta = new MockResponse()
                .setResponseCode(HttpStatus.OK.value())
                .setBody(new JSONArray("[\n" +
                        "{\n" +
                        "\"id\":49,\n" +
                        "\"mensaje\":\"Tweet de Namba\",\n" +
                        "\"usuarioCreadorId\":3,\n" +
                        "\"fechaCreacion\":\"25/02/2024 17:41\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\":48,\n" +
                        "\"mensaje\":\"Tweet de Namba\",\n" +
                        "\"usuarioCreadorId\":3,\n" +
                        "\"fechaCreacion\":\"25/02/2024 17:41\"\n" +
                        "}\n" +
                        "]").toString())
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        this.respuestas.add(respuesta);
        return this;
    }

//    public TweetMockWebService conDosTweetsPaginaCeroOrdenadoFechaCreacionDesc() throws JSONException {
//        MockResponse respuesta = new MockResponse()
//                .setResponseCode(HttpStatus.OK.value())
//                .setBody(new JSONArray("[\n" +
//                        "        {\n" +
//                        "            \"id\": \"41\",\n" +
//                        "            \"mensaje\": \"Hola\",\n" +
//                        "            \"usuarioCreadorId\": 2,\n" +
//                        "            \"fechaCreacion\": \"25/02/2024 16:21\"\n" +
//                        "        },\n" +
//                        "        {\n" +
//                        "            \"id\": \"42\",\n" +
//                        "            \"mensaje\": \"Hola\",\n" +
//                        "            \"usuarioCreadorId\": 2,\n" +
//                        "            \"fechaCreacion\": \"25/02/2024 16:21\"\n" +
//                        "        }\n" +
//                        "    ]").toString())
//                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
//        this.respuestas.add(respuesta);
//        return this;
//    }

    public MockWebServer mock() throws IOException {
        MockWebServer mockWebServer = new MockWebServer();
        mockWebServer.start(this.puerto);
        this.respuestas.forEach(mockWebServer::enqueue);
        return mockWebServer;
    }
}
