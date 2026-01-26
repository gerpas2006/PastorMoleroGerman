package com.salesianostriana.dam.PastorMoleroGerman.service;

import com.salesianostriana.dam.PastorMoleroGerman.dto.ViviendaDatails;
import com.salesianostriana.dam.PastorMoleroGerman.model.Vivienda;
import com.salesianostriana.dam.PastorMoleroGerman.repository.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViviendaService{

    private final ViviendaRepository viviendaRepository;

    public Page<Vivienda> filtar(Pageable pageable, ViviendaDatails viviendaDatails){
        return viviendaRepository.findBy(
                PredicateSpecification.allOf(
                        ViviendaFilter.filtrarCiudad(viviendaDatails.ciudad()),
                        ViviendaFilter.filtarPorBanos(viviendaDatails.numBanos()),
                        ViviendaFilter.filtarPorHabitaciones(viviendaDatails.numHabitaciones()),
                        ViviendaFilter.filtarPorGarage(viviendaDatails.garaje()),
                        ViviendaFilter.filtarPorEstado(viviendaDatails.estadoVivienda()),
                        ViviendaFilter.filtrarProvincia(viviendaDatails.provincia()),
                        ViviendaFilter.filtrarPorMetros(viviendaDatails.metrosMax(),viviendaDatails.metrosMin()),
                        ViviendaFilter.filtrarPorAscensor(viviendaDatails.ascensor()),
                        ViviendaFilter.filtarPorPrecio(viviendaDatails.precioMax(),viviendaDatails.precioMin()),
                        ViviendaFilter.filtarTipoVivienda(viviendaDatails.tipoVivienda())
                ),
                q -> q.page(pageable)
        );
    }

}
