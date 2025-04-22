package org.example.Repository;
import org.example.Model.JugadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JugadorRepository extends JpaRepository<JugadorModel,Long> {

}
