package com.salesianostriana.dam.GermanPastorMolero.dto;

import com.salesianostriana.dam.GermanPastorMolero.model.EstadoVivienda;
import com.salesianostriana.dam.GermanPastorMolero.model.TipoVivienda;
import com.salesianostriana.dam.GermanPastorMolero.model.Vivienda;

import java.time.LocalDate;

public record ViviendaResponse(
        Long id,
        String titulo,
        String ciudad,
        String provicia,
        Integer precio,
        Integer metrosCuadrados,
        Integer numHabitaciones,
        Integer banios,
        TipoVivienda tipoVivienda,
        EstadoVivienda estadoVivienda,
        Boolean ascensor,
        LocalDate fechaPublicacion) {

        public static ViviendaResponse viviendaResponse(Vivienda v){
            return new ViviendaResponse(
                    v.getId(),
                    v.getTitulo(),
                    v.getCiudad(),
                    v.getProvincia(),
                    v.getPrecio(),
                    v.getMetrosCuadrados(),
                    v.getNumHabitaciones(),
                    v.getBanios(),
                    v.getTipoVivienda(),
                    v.getEstadoVivienda(),
                    v.getAscensor(),
                    v.getFechaPublicacion()
            );
        }
}