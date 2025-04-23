package org.example.Controller;

import org.example.Model.EntrenadorModel;
import org.example.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/{id}")
    public ResponseEntity<EntrenadorModel> getById(@PathVariable Long id) {
        return entrenadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EntrenadorModel create(@RequestBody EntrenadorModel entrenador) {
        return entrenadorService.save(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrenadorModel> update(@PathVariable Long id, @RequestBody EntrenadorModel entrenador) {
        return entrenadorService.update(id, entrenador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return entrenadorService.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
