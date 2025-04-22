package org.example.Service;
import org.example.Model.EstadisticasModel;
import org.example.Repository.EstadisticasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstadisticasService {

    @Autowired
    private EstadisticasRepository estadisticasRepository;

    public Optional<EstadisticasModel> findById(Long id) {
        return estadisticasRepository.findById(id);
    }

    public EstadisticasModel save(EstadisticasModel estadisticasModel) {
        return estadisticasRepository.save(estadisticasModel);
    }

    public Optional<EstadisticasModel> update(Long id, EstadisticasModel estadisticasModel) {
        return estadisticasRepository.findById(id)
                .map(existing -> {
                    estadisticasModel.setId(id);
                    return estadisticasRepository.save(estadisticasModel);
                });
    }

    public boolean deleteById(Long id) {
        if (estadisticasRepository.existsById(id)) {
            estadisticasRepository.deleteById(id);
            return true;
        }
        return false;
    }
}