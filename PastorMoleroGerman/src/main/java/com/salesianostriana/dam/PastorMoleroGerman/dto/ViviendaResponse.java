package com.salesianostriana.dam.PastorMoleroGerman.dto;

import com.salesianostriana.dam.PastorMoleroGerman.model.EstadoVivienda;
import com.salesianostriana.dam.PastorMoleroGerman.model.TipoVivienda;
import com.salesianostriana.dam.PastorMoleroGerman.model.Vivienda;

import java.time.LocalDate;

public record ViviendaResponse(
        Long id,
        String titulo,
        String ciudad,
        Integer precio,
        Integer metrosCuadrados,
        Integer numHabitaciones,
        Integer banos,
        TipoVivienda tipoVivienda,
        EstadoVivienda estadoVivienda,
        boolean disponible,
        LocalDate fechaPublicacion
) {
    public static ViviendaResponse viviendaResponse(Vivienda v){
        return new ViviendaResponse(
                v.getId(),
                v.getTitulo(),
                v.getCiudad(),
                v.getPrecio(),
                v.getMetrosCuadrados(),
                v.getNumHabitaciones(),
                v.getBanos(),
                v.getTipoVivienda(),
                v.getEstadoVivienda(),
                v.isDisponible(),
                v.getFechaPublicacion()
        );
    }
}
