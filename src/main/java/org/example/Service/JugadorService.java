package org.example.Service;
import org.example.Model.JugadorModel;
import org.example.Repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public Optional<JugadorModel> findById(Long id) {
        return jugadorRepository.findById(id);
    }

    public JugadorModel save(JugadorModel jugadorModel) {
        return jugadorRepository.save(jugadorModel);
    }

    public Optional<JugadorModel> update(Long id, JugadorModel jugadorModel) {
        return jugadorRepository.findById(id)
                .map(existing -> {
                    jugadorModel.setId(id);
                    return jugadorRepository.save(jugadorModel);
                });
    }

    public boolean deleteById(Long id) {
        if (jugadorRepository.existsById(id)) {
            jugadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}