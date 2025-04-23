package org.example.Repository;
import org.example.Model.JugadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface JugadorRepository extends JpaRepository<JugadorModel,Long> {

    @Query(value = "SELECT * FROM jugador WHERE equipo_id = :idEquipo", nativeQuery = true)
    List<JugadorModel> findByEquipoId(@Param("idEquipo") Long idEquipo);

    // Consulta 3. Jugadores con más de X goles
    @Query(value = """
    SELECT j.* FROM jugador j
    JOIN estadisticas e ON j.id = e.id_jugador
    GROUP BY j.id
    HAVING SUM(e.goles) < :goles
""", nativeQuery = true)
    List<JugadorModel> findJugadoresConMasDeXGoles(@Param("goles") int goles);

}
