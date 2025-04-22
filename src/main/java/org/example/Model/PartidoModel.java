package org.example.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "Partido")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PartidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String estadio;
    @ManyToOne
    @JoinColumn(name = "equipo_local", nullable = false)
    private EquipoModel equipolocal;
    @ManyToOne
    @JoinColumn(name = "equipo_visita", nullable = false)
    private EquipoModel equipovisitante;
    private int goles_local;
    private int goles_visita;
}
