package org.example.Controller;

import org.example.Model.EstadisticasModel;
import org.example.Service.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasController {

    @Autowired
    private EstadisticasService estadisticasService;

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticasModel> getById(@PathVariable Long id) {
        return estadisticasService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EstadisticasModel create(@RequestBody EstadisticasModel estadistica) {
        return estadisticasService.save(estadistica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadisticasModel> update(@PathVariable Long id, @RequestBody EstadisticasModel estadistica) {
        return estadisticasService.update(id, estadistica)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return estadisticasService.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
