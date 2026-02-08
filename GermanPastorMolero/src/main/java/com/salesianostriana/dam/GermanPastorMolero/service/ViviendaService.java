package com.salesianostriana.dam.GermanPastorMolero.service;

import com.salesianostriana.dam.GermanPastorMolero.dto.ViviendaCreateRequest;
import com.salesianostriana.dam.GermanPastorMolero.dto.ViviendaDetails;
import com.salesianostriana.dam.GermanPastorMolero.model.EstadoVivienda;
import com.salesianostriana.dam.GermanPastorMolero.model.TipoVivienda;
import com.salesianostriana.dam.GermanPastorMolero.model.Vivienda;
import com.salesianostriana.dam.GermanPastorMolero.repository.ViviendaRepository;
import com.salesianostriana.dam.GermanPastorMolero.validation.MetrosCuadradosFueraRango;
import com.salesianostriana.dam.GermanPastorMolero.validation.PrecioFueraDeRango;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

    public Page<Vivienda> filtarTodo(Pageable pageable, ViviendaDetails viviendaDetails){
        return viviendaRepository.findBy(
                PredicateSpecification.allOf(
                        ViviendaFilter.filtarPorAscensor(viviendaDetails.ascensor()),
                        ViviendaFilter.filtarPorBanios(viviendaDetails.numBanos()),
                        ViviendaFilter.filtrarPorEstadoVivienda(viviendaDetails.estadoVivienda()),
                        ViviendaFilter.filtarPorGaraje(viviendaDetails.garaje()),
                        ViviendaFilter.filtarPorHabitaciones(viviendaDetails.numHabitaciones()),
                        ViviendaFilter.filtarPorPrecio(viviendaDetails.precioMin(),viviendaDetails.precioMax()),
                        ViviendaFilter.filtrarPorMetros(viviendaDetails.metrosMin(),viviendaDetails.metrosMax()),
                        ViviendaFilter.filtarPorProvincia(viviendaDetails.provincia()),
                        ViviendaFilter.filtarPorTerraza(viviendaDetails.terraza()),
                        ViviendaFilter.filtrarPorCiudad(viviendaDetails.ciudad()),
                        ViviendaFilter.filtarPorTipoVivienda(viviendaDetails.tipoVivienda()),
                        ViviendaFilter.filtarPorDisponible(viviendaDetails.disponible())
                ), q -> q.page(pageable)
        );
    }

    public Vivienda crearVivienda(ViviendaCreateRequest viviendaCreateRequest) {
        Vivienda v = Vivienda.builder()
                .titulo(viviendaCreateRequest.titulo())
                .descripcion(viviendaCreateRequest.descripcion())
                .ciudad(viviendaCreateRequest.ciudad())
                .provincia(viviendaCreateRequest.provincia())
                .precio(viviendaCreateRequest.precio())
                .metrosCuadrados(viviendaCreateRequest.metrosCuadrados())
                .numHabitaciones(viviendaCreateRequest.habitaciones())
                .banios(viviendaCreateRequest.banios())
                .tipoVivienda(viviendaCreateRequest.tipoVivienda())
                .estadoVivienda(viviendaCreateRequest.estadoVivienda())
                .ascensor(viviendaCreateRequest.ascensor())
                .terraza(viviendaCreateRequest.terraza())
                .garaje(viviendaCreateRequest.garaje())
                .disponible(viviendaCreateRequest.disponible())
                .build();
        return viviendaRepository.save(v);
    }
}
