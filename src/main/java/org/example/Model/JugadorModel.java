package org.example.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "Jugador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JugadorModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String posicion;
    private int dorsal;
    private LocalDate fecha_nac;
    private String nacionalidad;
    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    private EquipoModel equipo;
}
