package org.iesvdm.eventos.repository;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.eventos.model.Evento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class EventoRepository {

    JdbcTemplate jdbcTemplate;

    public EventoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Evento> findAll() {
        List<Evento> eventos = jdbcTemplate.query("""
                select * from evento;
                """,
                (rs, rowNum) -> new Evento(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getTimestamp("fecha").toLocalDateTime(),
                        rs.getString("lugar"),
                        rs.getBigDecimal("precio_base"),
                        rs.getBigDecimal("recargo_grada"),
                        rs.getBigDecimal("recargo_vip")
                )
        );
        return eventos;
    }
}
