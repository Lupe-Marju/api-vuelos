package com.example.api_vuelos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class VueloDTO {
    private Integer idVuelo;
    private String nombreV;
    private String aerolinea;
    private String ciudadSalida;
    private String ciudadLlegada;
    private LocalDate diaSalida;
    private LocalDate diaLlegada;
    private int duracionDias;
}
