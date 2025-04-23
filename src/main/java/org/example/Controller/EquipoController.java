package org.example.Controller;

import org.example.Model.EquipoModel;
import org.example.Service.EquipoService;
import org.example.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private PartidoRepository partidoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<EquipoModel> getById(@PathVariable Long id) {
        return equipoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EquipoModel create(@RequestBody EquipoModel equipo) {
        return equipoService.save(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipoModel> update(@PathVariable Long id, @RequestBody EquipoModel equipo) {
        return equipoService.update(id, equipo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return equipoService.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // 🎯 Consulta nativa: Total de goles del equipo
    @GetMapping("/{id}/total-goles")
    public Integer obtenerTotalGoles(@PathVariable Long id) {
        return partidoRepository.totalGolesPorEquipo(id);
    }
}
