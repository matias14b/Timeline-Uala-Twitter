package com.ejercicio.uala.timeline.controller.rest;

import com.ejercicio.uala.timeline.dto.TweetDTO;
import com.ejercicio.uala.timeline.repository.TimeLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TimelineRestController {

    private final TimeLineRepository timeLineRepository;

    @GetMapping("/api/timeline/tweets/{idUsuarios}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<TweetDTO> obtenerTweetsPorUsuariosId(@PathVariable List<Long> idUsuarios, @RequestParam long pagina, @RequestParam long tamaño) {
        return timeLineRepository.iniciarSesion(idUsuarios, pagina, tamaño);
    }
}
