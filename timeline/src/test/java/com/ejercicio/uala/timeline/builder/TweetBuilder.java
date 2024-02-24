package com.ejercicio.uala.timeline.builder;

import com.ejercicio.uala.timeline.dto.TweetDTO;

import java.time.LocalDateTime;

public class TweetBuilder {

    private String mensaje;
    private Long usuarioCreadorId;
    private LocalDateTime fechaCreacion;

    public static TweetBuilder base() {
        TweetBuilder builder = new TweetBuilder();
        builder.mensaje = "mensaje base";
        builder.usuarioCreadorId = 1L;
        return builder;
    }

    public TweetBuilder conMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }


    public TweetBuilder conUsuarioCreacionId(Long id) {
        this.usuarioCreadorId = id;
        return this;
    }

    public TweetBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public TweetDTO build() {
        TweetDTO tweet = new TweetDTO();
        tweet.setMensaje(mensaje);
        tweet.setFechaCreacion(fechaCreacion);
        tweet.setUsuarioCreadorId(usuarioCreadorId);
        return tweet;
    }
}
