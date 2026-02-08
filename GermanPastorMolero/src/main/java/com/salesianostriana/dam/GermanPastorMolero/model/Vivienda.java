package com.salesianostriana.dam.GermanPastorMolero.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "viviendas")
public class Vivienda {

    @GeneratedValue
    @Id
    private Long id;

    private String titulo;
    @Lob
    private String descripcion;
    private String ciudad;
    private String provincia;
    private Integer precio;
    private Integer metrosCuadrados;
    private Integer numHabitaciones;
    private Integer banios;
    @Enumerated(EnumType.STRING)
    private TipoVivienda tipoVivienda;
    @Enumerated(EnumType.STRING)
    private EstadoVivienda estadoVivienda;
    private Boolean ascensor;
    private Boolean terraza;
    private Boolean garaje;
    private Boolean disponible;
    private LocalDate fechaPublicacion;
}
