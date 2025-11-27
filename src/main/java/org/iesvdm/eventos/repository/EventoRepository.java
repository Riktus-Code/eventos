package org.iesvdm.eventos.repository;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.eventos.model.Evento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
                        //rs.getObject("fecha", LocalDateTime.class)
                        rs.getTimestamp("fecha").toLocalDateTime(),
                        rs.getString("lugar"),
                        rs.getBigDecimal("precio_base"),
                        rs.getBigDecimal("recargo_grada"),
                        rs.getBigDecimal("recargo_vip")
                )
        );
        return eventos;
    }
    /*
    * @param id
    * @return
    * @throws org.springframework.dao.DataAccessException si no se ecnuenta el id
    *
    * */
    public Evento findById(int id){
       return jdbcTemplate.queryForObject("""
                    select * from evento where id=?;
                   """,(rs, rowNum) -> Evento.builder()
                       .id(rs.getInt("id"))
                .nombre(rs.getString("nombre"))
                .descripcion(rs.getString("descripcion"))
                .fecha(rs.getObject("fecha", LocalDateTime.class))
                .lugar(rs.getString("lugar"))
                .precioBase(rs.getBigDecimal("precio_base"))
                .recargoGrada(rs.getBigDecimal("recargo_grada"))
                .recargoVip(rs.getBigDecimal("recargo_vip"))
                .build()
                ,id

        );
    }
}