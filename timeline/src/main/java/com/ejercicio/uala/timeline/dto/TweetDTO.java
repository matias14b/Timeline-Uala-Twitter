package com.ejercicio.uala.timeline.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TweetDTO implements Serializable {
    private String mensaje;
    private Long usuarioCreadorId;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaCreacion;

    public TweetDTO() {

    }
}
