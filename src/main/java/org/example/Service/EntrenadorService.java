package org.example.Service;
import org.example.Model.EntrenadorModel;
import org.example.Repository.EntrenadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Optional<EntrenadorModel> findById(Long id) {
        return entrenadorRepository.findById(id);
    }

    public EntrenadorModel save(EntrenadorModel entrenadorModel) {
        return entrenadorRepository.save(entrenadorModel);
    }

    public Optional<EntrenadorModel> update(Long id, EntrenadorModel entrenadorModel) {
        return entrenadorRepository.findById(id)
                .map(existing -> {
                    entrenadorModel.setId(id);
                    return entrenadorRepository.save(entrenadorModel);
                });
    }

    public boolean deleteById(Long id) {
        if (entrenadorRepository.existsById(id)) {
            entrenadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}