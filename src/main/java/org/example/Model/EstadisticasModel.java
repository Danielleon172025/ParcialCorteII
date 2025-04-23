package org.example.Model;
import jakarta.persistence.*;
import lombok.*;




@Entity
@Table(name = "Estadisticas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_jugador", nullable = false)
    private JugadorModel jugador;
    @ManyToOne
    @JoinColumn(name = "id_partido", nullable = false)
    private PartidoModel partido;
    private int minutos_jugados;
    private int goles;
    private int asistencias;
    private int tarjetas_amarillas;
    private int tarjetas_rojas;

}
