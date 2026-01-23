package com.salesianostriana.dam.PastorMoleroGerman.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "vivendas")
public class Vivienda {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;


    private String titulo;
    private String descripcion;
    private String ciudad;
    private String provincia;
    private Integer precio;
    private Integer metrosCuadrados;
    private Integer numHabitaciones;
    private Integer banos;

    @Enumerated(EnumType.STRING)
    private TipoVivienda tipoVivienda;

    @Enumerated(EnumType.STRING)
    private EstadoVivienda estadoVivienda;

    private boolean ascensor;
    private boolean terraza;
    private boolean garaje;
    private boolean disponible;
    private LocalDate fechaPublicacion;


}
