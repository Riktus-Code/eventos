package org.iesvdm.eventos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Evento {

    private Integer id;

    private String nombre;

    private String descripcion;

    private LocalDateTime fecha;

    private String lugar;

    private BigDecimal precioBase;

    private BigDecimal recargoGrada;

    private BigDecimal recargoVip;


}
