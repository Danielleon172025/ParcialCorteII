package org.example.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Entrenador")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EntrenadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private EquipoModel equipo;
}
