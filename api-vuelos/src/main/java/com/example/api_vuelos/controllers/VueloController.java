package com.example.api_vuelos.controllers;

import com.example.api_vuelos.dto.VueloDTO;
import com.example.api_vuelos.models.Vuelo;
import com.example.api_vuelos.services.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloService sercive;

    @GetMapping("")
    public ResponseEntity<List<VueloDTO>> listarVuelos(@RequestParam("empresa") Optional<String> empresa,
                                                       @RequestParam("lugarLlegada") Optional<String> lugarLlegada,
                                                       @RequestParam("lugarSalida") Optional<String> lugarSalida,
                                                       @RequestParam("fechaSalida") Optional<LocalDate> fechaSalida,
                                                       @RequestParam("fechaLlegada") Optional<LocalDate> fechaLlegada,
                                                       @RequestParam("orderBy") Optional<String> orden) {
        List<VueloDTO> vuelosListados = sercive.filtrarVuelos(empresa, lugarLlegada, lugarSalida, fechaSalida, fechaLlegada, orden);
        return ResponseEntity.ok(vuelosListados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VueloDTO>> buscarVueloId(@PathVariable Integer id) {
        return ResponseEntity.ok(sercive.buscarVueloId(id));
    }

    @PostMapping("")
    public ResponseEntity<String> agregarVuelo(@RequestBody Vuelo vuelo) {
        if (!sercive.agregarVuelo(vuelo)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los campos ingresados son incorrectos. El vuelo no se ha podido guardar.");
        }
        return ResponseEntity.ok("Vuelo guardado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarVuelo(@PathVariable Integer id, @RequestBody Vuelo vuelo) {
        if (!sercive.actualizarVuelo(id, vuelo)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los campos ingresados son incorrectos o el id del vuelo es incorrecto. El vuelo no se ha podido actualizar.");
        }
        return ResponseEntity.ok("Vuelo actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVuelo(@PathVariable Integer id) {
        if (!sercive.borrarVuelo(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vuelo no encontrado");
        }
        return ResponseEntity.ok("Vuelo eliminado correctamente.");
    }
}
