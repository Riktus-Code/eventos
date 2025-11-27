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
public class CompraEntrada {


    private Integer id;

    private Integer eventoId;

    private String nombreComprador;

    private String emailComprador;

    private Integer numeroEntrada;

    private BigDecimal precioUnitario;

    private BigDecimal precioTotal;

    private LocalDateTime fechaCompra;

}