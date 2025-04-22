package org.example.Service;
import org.example.Model.EquipoModel;
import org.example.Repository.EquipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public Optional<EquipoModel> findById(Long id) {
        return equipoRepository.findById(id);
    }

    public EquipoModel save(EquipoModel equipoModel) {
        return equipoRepository.save(equipoModel);
    }

    public Optional<EquipoModel> update(Long id, EquipoModel equipoModel) {
        return equipoRepository.findById(id)
                .map(existing -> {
                    equipoModel.setId(id);
                    return equipoRepository.save(equipoModel);
                });
    }

    public boolean deleteById(Long id) {
        if (equipoRepository.existsById(id)) {
            equipoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}