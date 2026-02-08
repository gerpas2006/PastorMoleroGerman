package com.salesianostriana.dam.GermanPastorMolero.dto;

import com.salesianostriana.dam.GermanPastorMolero.model.EstadoVivienda;
import com.salesianostriana.dam.GermanPastorMolero.model.TipoVivienda;
import com.salesianostriana.dam.GermanPastorMolero.validation.MetrosCuadradosFueraRango;
import com.salesianostriana.dam.GermanPastorMolero.validation.PrecioFueraDeRango;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ViviendaCreateRequest(
        @NotBlank
        @Size(max = 120)
        String titulo,
        @Size(max = 2000)
        String descripcion,
        @NotBlank
        @Size(max = 80)
        String ciudad,
        @NotBlank
        @Size(max = 80)
        String provincia,
        @NotNull
        @Min(0)
        @PrecioFueraDeRango(precio = 1_000_000)
        Integer precio,
        @NotNull
        @Min(1)
        @MetrosCuadradosFueraRango(metrosCuadrados = 1_000)
        Integer metrosCuadrados,
        @NotNull
        @Min(0)
        Integer habitaciones,
        @NotNull
        @Min(0)
        Integer banios,
        @NotNull
        TipoVivienda tipoVivienda,
        @NotNull
        EstadoVivienda estadoVivienda,
        @NotNull
        Boolean ascensor,
        @NotNull
        Boolean terraza,
        @NotNull
        Boolean garaje,
        @NotNull
        Boolean disponible
) {
}
