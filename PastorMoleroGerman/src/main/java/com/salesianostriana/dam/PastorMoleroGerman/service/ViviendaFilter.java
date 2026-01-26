package com.salesianostriana.dam.PastorMoleroGerman.service;

import com.salesianostriana.dam.PastorMoleroGerman.model.EstadoVivienda;
import com.salesianostriana.dam.PastorMoleroGerman.model.TipoVivienda;
import com.salesianostriana.dam.PastorMoleroGerman.model.Vivienda;
import org.springframework.data.jpa.domain.PredicateSpecification;

public interface ViviendaFilter {

     static PredicateSpecification<Vivienda> filtrarCiudad(String ciudad){
        return ((from, builder) ->
                builder.like(builder.lower(from.get("ciudad")), "%" + ciudad.toLowerCase() + "%"));
    }

     static PredicateSpecification<Vivienda> filtrarProvincia(String provincia){
        return ((from, builder) ->
                builder.equal(builder.lower(from.get("provincia")), "%" + provincia.toLowerCase() + "%"));
    }

     static PredicateSpecification<Vivienda> filtarTipoVivienda(TipoVivienda tipoVivienda){
        return ((from, builder) ->
                builder.equal(builder.lower(from.get("tipoVivienda")), tipoVivienda));
    }

     static PredicateSpecification<Vivienda> filtarPorEstado(EstadoVivienda estadoVivienda){
        return (from, builder) ->
                builder.equal(builder.lower(from.get("estadoVivienda")), estadoVivienda);
    }

     static PredicateSpecification<Vivienda> filtrarPorAscensor(boolean ascensor){
        return (from, builder) ->
                builder.isTrue(from.get("ascensor"));
    }
     static PredicateSpecification<Vivienda> filtrarPorTerraza(){
        return (from, builder) ->
                builder.isTrue(from.get("terraza"));
    }

     static PredicateSpecification<Vivienda> filtarPorGarage(boolean garaje){
        return (from, builder) ->
                builder.isTrue(from.get("garage"));
    }

     static PredicateSpecification<Vivienda> filtarPorPrecio(Integer precioMax, Integer precioMin){
         int precioMaxReal = precioMax == null ? 0 : precioMax;
         int precioMinReal = precioMin == null ? 0 : precioMin ;
         return (from, criteriaBuilder) ->
                 criteriaBuilder.between(from.get("precio"),precioMinReal,precioMaxReal);
     }

    static PredicateSpecification<Vivienda> filtrarPorMetros(Integer metrosMax,Integer metrosMin){
        double metrosMaxReal = metrosMax == null ? 0 : metrosMax;
        double metrosMnReal = metrosMin == null ? 0: metrosMin;
        return (from, criteriaBuilder) ->
                criteriaBuilder.between(from.get("metrosCuadrados"),metrosMaxReal,metrosMnReal);
    }

    static PredicateSpecification<Vivienda> filtarPorHabitaciones(Integer numHabitacion){
         return (from, criteriaBuilder) ->
                 criteriaBuilder.greaterThan(from.get("numHabitaciones"),numHabitacion);
    }

    static PredicateSpecification<Vivienda> filtarPorBanos(Integer numBanos){
         return (from, criteriaBuilder) ->
                 criteriaBuilder.greaterThan(from.get("banos"),numBanos);
    }

}
