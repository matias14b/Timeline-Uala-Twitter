package com.ejercicio.uala.timeline.controller.rest;

import com.ejercicio.uala.timeline.dto.TimeLineDTO;
import com.ejercicio.uala.timeline.service.TimeLineServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class TimelineRestController {

    private final TimeLineServiceImpl timeLineService;

    @GetMapping("/api/timeline/{idUsuario}")
    @ResponseStatus(HttpStatus.CREATED)
    public TimeLineDTO obtenerTimeLinePorUsuarioId(@PathVariable Long idUsuario, @RequestParam int pagina, @RequestParam int tamanio, @RequestParam String sort) {
        return timeLineService.obtenerTimeLinePorUsuarioId(idUsuario, pagina, tamanio, sort);
    }
}
