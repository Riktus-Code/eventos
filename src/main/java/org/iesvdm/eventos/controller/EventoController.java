package org.iesvdm.eventos.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.eventos.model.Evento;
import org.iesvdm.eventos.service.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@SessionAttributes("evento")
@RequestMapping("/eventos")
public class EventoController {

    private EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @ModelAttribute("datos")
    public Evento iniciar() {
        return new Evento();
    }

    @GetMapping("/calcular/paso1")
    public String calcularPaso1(Model model) {
        List<Evento> eventos = eventoService.findAllEvents();

        model.addAttribute("eventos", eventos);
        return "paso1";
    }

    @PostMapping("/calcular/paso1")
    public String calcularPaso1Post(@ModelAttribute("evento") Evento evento) {
        return "paso2";
    }
}
