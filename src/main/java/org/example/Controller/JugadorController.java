package org.example.Controller;

import org.example.Model.JugadorModel;
import org.example.Service.JugadorService;
import org.example.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @Autowired
    private JugadorRepository jugadorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<JugadorModel> getById(@PathVariable Long id) {
        return jugadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public JugadorModel create(@RequestBody JugadorModel jugador) {
        return jugadorService.save(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorModel> update(@PathVariable Long id, @RequestBody JugadorModel jugador) {
        return jugadorService.update(id, jugador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return jugadorService.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // 🔍 Consultas Nativas
    @GetMapping("/por-equipo/{equipoId}")
    public List<JugadorModel> getByEquipo(@PathVariable Long equipoId) {
        return jugadorRepository.findByEquipoId(equipoId);
    }

    @GetMapping("/goleadores")
    public List<JugadorModel> getGoleadores(@RequestParam int minimoGoles) {
        return jugadorRepository.findJugadoresConMasDeXGoles(minimoGoles);
    }
}
