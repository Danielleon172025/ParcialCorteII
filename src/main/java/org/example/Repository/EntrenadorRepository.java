package org.example.Repository;

import org.example.Model.EntrenadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EntrenadorRepository extends JpaRepository<EntrenadorModel,Long> {

}
