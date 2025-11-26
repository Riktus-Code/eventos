package org.iesvdm.eventos.service;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.eventos.model.Evento;
import org.iesvdm.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EventoService {
    @Autowired
    private  final EventoRepository eventoRepository;
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> findAllEvents() {
        return eventoRepository.findAll();
    }
}
