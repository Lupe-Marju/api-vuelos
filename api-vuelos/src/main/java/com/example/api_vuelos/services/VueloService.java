package com.example.api_vuelos.services;

import com.example.api_vuelos.dto.VueloDTO;
import com.example.api_vuelos.models.Vuelo;
import com.example.api_vuelos.repositories.VueloRepository;
import com.example.api_vuelos.utils.VueloUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class VueloService {

    @Autowired
    private VueloRepository repository;

    private Integer contador = 11;
    private final String COMPARADOR = "empresa";


    public List<VueloDTO> filtrarVuelos(Optional<String> empresa, Optional<String> lugarLlegada, Optional<String> lugarSalida, Optional<LocalDate> fechaSalida, Optional<LocalDate> fechaLlegada, Optional<String> orden) {
        return repository.findAll().stream()
                .filter(empresa.isPresent() ? a -> a.getEmpresa().equalsIgnoreCase(empresa.get()) : a -> true)
                .filter(lugarLlegada.isPresent() ? a -> a.getLugarLlegada().equalsIgnoreCase(lugarLlegada.get()) : a -> true)
                .filter(lugarSalida.isPresent() ? a -> a.getLugarSalida().equalsIgnoreCase(lugarSalida.get()) : a -> true)
                .filter(fechaLlegada.isPresent() ? a -> a.getFechaLlegada().isEqual(fechaLlegada.get()) : a -> true)
                .filter(fechaSalida.isPresent() ? a -> a.getFechaSalida().isEqual(fechaSalida.get()) : a -> true)
                .sorted(orden.isEmpty() ? (Comparator.comparing(Vuelo::getFechaSalida)) : orden.get().equalsIgnoreCase(COMPARADOR) ? (Comparator.comparing(Vuelo::getEmpresa)) : (Comparator.comparing(Vuelo::getLugarLlegada)))
                .map(a -> VueloUtil.convetirAVueloDTO(a))
                .toList();
    }

    public Optional<VueloDTO> buscarVueloId(Integer id) {
        Optional<Vuelo> vuelo = repository.findById(id);
        if (vuelo.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(VueloUtil.convetirAVueloDTO(vuelo.get()));
    }

    public boolean agregarVuelo(Vuelo vuelo) {
        if (VueloUtil.comprobarDatosVuelo(vuelo)) {
            return false;
        }
        vuelo.setId(contador++);
        repository.save(vuelo);
        return true;
    }

    public boolean actualizarVuelo(Integer id, Vuelo vuelo) {
        if (!repository.isIdPresent(id) || VueloUtil.comprobarDatosVuelo(vuelo)) {
            return false;
        }
        vuelo.setId(id);
        repository.save(vuelo);
        return true;
    }

    public boolean borrarVuelo(Integer id) {
        Optional<Vuelo> vuelo = repository.findById(id);
        if (vuelo.isEmpty()) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
