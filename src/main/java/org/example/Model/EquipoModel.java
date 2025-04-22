package org.example.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

    @Entity
    @Table(name = "Equipo")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class EquipoModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String ciudad;
        private LocalDate fundacion;
    }

