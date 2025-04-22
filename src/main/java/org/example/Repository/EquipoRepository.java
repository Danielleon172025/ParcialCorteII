package org.example.Repository;
import org.example.Model.EquipoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EquipoRepository extends JpaRepository<EquipoModel,Long> {
}
