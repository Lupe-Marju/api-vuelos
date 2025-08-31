package com.example.api_vuelos.utils;

import com.example.api_vuelos.dto.VueloDTO;
import com.example.api_vuelos.models.Vuelo;

import java.time.LocalDate;

public class VueloUtil {
    public static int calcularDiasVuelo(LocalDate fechaLlegada, LocalDate fechaSalida) {
        return fechaLlegada.compareTo(fechaSalida);
    }

    public static VueloDTO convetirAVueloDTO(Vuelo vuelo) {
        VueloDTO vueloDTO = new VueloDTO();
        vueloDTO.setNombreV(vuelo.getNombreVuelo());
        vueloDTO.setAerolinea(vuelo.getEmpresa());
        vueloDTO.setCiudadLlegada(vuelo.getLugarLlegada());
        vueloDTO.setCiudadSalida(vuelo.getLugarSalida());
        vueloDTO.setDiaLlegada(vuelo.getFechaLlegada());
        vueloDTO.setDiaSalida(vuelo.getFechaSalida());
        vueloDTO.setDuracionDias(calcularDiasVuelo(vuelo.getFechaLlegada(), vuelo.getFechaSalida()));
        return vueloDTO;
    }

    public static boolean comprobarDatosVuelo(Vuelo vuelo) {
        if (vuelo.getNombreVuelo() == null
                || vuelo.getNombreVuelo().isBlank()
                || vuelo.getEmpresa() == null
                || vuelo.getEmpresa().isBlank()
                || vuelo.getLugarLlegada() == null
                || vuelo.getLugarLlegada().isBlank()
                || vuelo.getLugarSalida() == null
                || vuelo.getLugarSalida().isBlank()
                || vuelo.getFechaLlegada() == null
                || vuelo.getFechaSalida() == null
                || vuelo.getFechaLlegada().isBefore(vuelo.getFechaSalida())
                || vuelo.getFechaSalida().isAfter(vuelo.getFechaLlegada())) {
            return true;
        }
        return false;
    }


}
