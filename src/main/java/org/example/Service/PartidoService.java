package org.example.Service;

import org.example.Model.PartidoModel;
import org.example.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public Optional<PartidoModel> findById(Long id) {
        return partidoRepository.findById(id);
    }

    public PartidoModel save(PartidoModel partidoModel) {
        return partidoRepository.save(partidoModel);
    }

    public Optional<PartidoModel> update(Long id, PartidoModel partidoModel) {
        return partidoRepository.findById(id)
                .map(existing -> {
                    partidoModel.setId(id);
                    return partidoRepository.save(partidoModel);
                });
    }

    public boolean deleteById(Long id) {
        if (partidoRepository.existsById(id)) {
            partidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
