package org.example.Repository;
import org.example.Model.EstadisticasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EstadisticasRepository extends JpaRepository<EstadisticasModel,Long>{

}
