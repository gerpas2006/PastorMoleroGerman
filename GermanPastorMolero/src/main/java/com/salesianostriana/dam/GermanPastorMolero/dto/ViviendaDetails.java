package com.salesianostriana.dam.GermanPastorMolero.dto;

import com.salesianostriana.dam.GermanPastorMolero.model.EstadoVivienda;
import com.salesianostriana.dam.GermanPastorMolero.model.TipoVivienda;

import java.time.LocalDate;

public record ViviendaDetails(
        String ciudad,
        String provincia,
        Integer precioMax,
        Integer precioMin,
        Integer metrosMin,
        Integer metrosMax,
        Integer numHabitaciones,
        Integer numBanos,
        TipoVivienda tipoVivienda,
        EstadoVivienda estadoVivienda,
        boolean terraza,
        boolean garaje,
        boolean ascensor,
        boolean disponible
) {
}
