package com.example.api_vuelos.repositories;

import com.example.api_vuelos.models.Vuelo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class VueloRepository {

    private HashMap<Integer, Vuelo> vuelos = new HashMap<>();
    private Integer contadorId = 11;

    public VueloRepository() {
        vuelos.put(1, new Vuelo(1, "RA1211", "Rayner", "Madrid", "Barcelona", LocalDate.of(2025, 9, 11), LocalDate.of(2025, 9, 12)));
        vuelos.put(2, new Vuelo(2, "LU1312", "Luftansa", "Madrid", "Buenos Aires", LocalDate.of(2025, 9, 4), LocalDate.of(2025, 9, 5)));
        vuelos.put(3, new Vuelo(3, "IB2121", "Iberia", "Barcelona", "Madrid", LocalDate.of(2025, 9, 14), LocalDate.of(2025, 9, 15)));
        vuelos.put(4, new Vuelo(4, "LV2331", "Level", "Madrid", "Barcelona", LocalDate.of(2025, 9, 12), LocalDate.of(2025, 9, 12)));
        vuelos.put(5, new Vuelo(5, "RA1014", "Rayner", "Buenos Aires", "Barcelona", LocalDate.of(2025, 9, 5), LocalDate.of(2025, 9, 6)));
        vuelos.put(6, new Vuelo(6, "VU4231", "Vueling", "Barcelona", "Londres", LocalDate.of(2025, 9, 21), LocalDate.of(2025, 9, 21)));
        vuelos.put(7, new Vuelo(7, "IB1145", "Iberia", "Madrid", "Londres", LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 10)));
        vuelos.put(8, new Vuelo(8, "LV5421", "Level", "Buenos Aires", "Barcelona", LocalDate.of(2025, 9, 26), LocalDate.of(2025, 9, 27)));
        vuelos.put(9, new Vuelo(9, "RA5426", "Rayner", "Madrid", "Paris", LocalDate.of(2025, 9, 15), LocalDate.of(2025, 9, 15)));
        vuelos.put(10, new Vuelo(10, "VU4251", "Vueling", "Paris", "Barcelona", LocalDate.of(2025, 9, 18), LocalDate.of(2025, 9, 18)));
    }

    public void save(Vuelo vuelo) {
        vuelos.put(vuelo.getId(), vuelo);
    }

    public List<Vuelo> findAll() {
        return vuelos.values().stream().toList();
    }

    public Optional<Vuelo> findById(Integer id) {
        return Optional.ofNullable(vuelos.get(id));
    }

    public boolean isIdPresent(Integer id) {
        return vuelos.containsKey(id);
    }

    // deleteById
    public void deleteById(Integer id) {
        vuelos.remove(id);
    }
}
