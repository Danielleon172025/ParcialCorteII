package org.example.Repository;

import org.example.Model.PartidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PartidoRepository extends JpaRepository<PartidoModel, Long> {

    // 🧠 Consulta 1: Resultados de todos los partidos con nombres de los equipos
    @Query(value = """
        SELECT 
            el.nombre AS equipo_local,
            ev.nombre AS equipo_visita,
            p.goles_local,
            p.goles_visita
        FROM partido p
        JOIN equipo el ON el.id = p.equipo_local
        JOIN equipo ev ON ev.id = p.equipo_visita
    """, nativeQuery = true)
    List<Map<String, Object>> obtenerResultadosConNombres();

    // 🧠 Consulta 2: Total de goles marcados por un equipo
    @Query(value = """
        SELECT SUM(p.goles_local) + SUM(p.goles_visita)
        FROM partido p
        WHERE p.equipo_local = :equipoId OR p.equipo_visita = :equipoId
    """, nativeQuery = true)
    Integer totalGolesPorEquipo(@Param("equipoId") Long equipoId);
}