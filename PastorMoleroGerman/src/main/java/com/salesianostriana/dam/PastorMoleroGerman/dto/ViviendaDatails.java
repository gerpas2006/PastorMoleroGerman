package com.salesianostriana.dam.PastorMoleroGerman.dto;

import com.salesianostriana.dam.PastorMoleroGerman.model.EstadoVivienda;
import com.salesianostriana.dam.PastorMoleroGerman.model.TipoVivienda;

public record ViviendaDatails(
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
        boolean ascensor
) {
}
