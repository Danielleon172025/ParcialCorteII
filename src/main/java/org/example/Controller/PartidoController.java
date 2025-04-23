package org.example.Controller;

import org.example.Model.PartidoModel;
import org.example.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    @Autowired
    private PartidoRepository partidoRepository;

    // 🔍 Consulta nativa: Resultados de partidos con nombres de equipos
    @GetMapping("/resultados")
    public List<Map<String, Object>> obtenerResultados() {
        return partidoRepository.obtenerResultadosConNombres();
    }

    // 🔍 Consulta nativa: Total de goles por equipo
    @GetMapping("/total-goles/{equipoId}")
    public Integer obtenerTotalGolesPorEquipo(@PathVariable Long equipoId) {
        return partidoRepository.totalGolesPorEquipo(equipoId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoModel> getById(@PathVariable Long id) {
        Optional<PartidoModel> partido = partidoRepository.findById(id);
        return partido.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PartidoModel create(@RequestBody PartidoModel partido) {
        return partidoRepository.save(partido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidoModel> update(@PathVariable Long id, @RequestBody PartidoModel partido) {
        return partidoRepository.findById(id)
                .map(existing -> {
                    partido.setId(id);
                    return ResponseEntity.ok(partidoRepository.save(partido));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (partidoRepository.existsById(id)) {
            partidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
