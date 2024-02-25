package com.ejercicio.uala.timeline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TimeLineDTO implements Serializable {
    private String username;
    private long usuarioId;
    private List<TweetDTO> tweets = new ArrayList<>();
}
