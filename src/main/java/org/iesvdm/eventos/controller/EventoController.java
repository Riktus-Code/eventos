package org.iesvdm.eventos.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.iesvdm.eventos.dto.PostPaso2DTO;
import org.iesvdm.eventos.model.CompraEntrada;
import org.iesvdm.eventos.model.Evento;
import org.iesvdm.eventos.service.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@Slf4j
@SessionAttributes({"evento","compraEntrada"})
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }



    @GetMapping("/calcular/paso1")
    public String calcularPaso1(Evento evento, Model model, CompraEntrada compraEntrada) {

        log.info("calcularPaso1",evento);
        List<Evento> eventos = eventoService.findAllEvents();

        model.addAttribute("eventos", eventos);
        model.addAttribute("eventoGet",evento);
        model.addAttribute("compraEntrada",compraEntrada != null ? compraEntrada.getNumeroEntrada(): null);
        return "paso1";
    }

    @PostMapping("/calcular/paso2")
    public String calcularPaso2Post(Evento evento, @ModelAttribute PostPaso2DTO postPaso2DTO, HttpSession httpSession, Model model) {
        log.info("calcularPaso2Post", postPaso2DTO);

        Evento eventoBd = eventoService.findEventoId(postPaso2DTO.getEventoId());

        httpSession.setAttribute("evento", eventoBd);
        httpSession.setAttribute("compraEntrada",CompraEntrada.builder().numeroEntrada(postPaso2DTO.getCantidadEntradas()).build());
        model.addAttribute("evento",eventoBd);

        return "paso2";
    }


}
