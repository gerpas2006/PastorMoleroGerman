package com.salesianostriana.dam.GermanPastorMolero.service;

import com.salesianostriana.dam.GermanPastorMolero.model.EstadoVivienda;
import com.salesianostriana.dam.GermanPastorMolero.model.TipoVivienda;
import com.salesianostriana.dam.GermanPastorMolero.model.Vivienda;
import org.springframework.data.jpa.domain.PredicateSpecification;

public interface ViviendaFilter {
    static PredicateSpecification<Vivienda> filtrarPorCiudad(String ciudad){
        return (from, criteriaBuilder) ->
                ciudad == null ? criteriaBuilder.and() : criteriaBuilder.like(from.get("ciudad"),ciudad);
    }

    static PredicateSpecification<Vivienda> filtarPorProvincia(String provincia){
        return (from, criteriaBuilder) ->
                provincia == null ? criteriaBuilder.and() : criteriaBuilder.equal(from.get("provincia"),provincia);
    }

    static PredicateSpecification<Vivienda> filtarPorPrecio(Integer precioMin,Integer precioMax){
        Integer precioMinReal = precioMin == null ? 0 : precioMin;
        Integer precioMaxReal = precioMax == null ? 0 : precioMax;
        return (from, criteriaBuilder) ->
                criteriaBuilder.between(from.get("precio"),precioMinReal,precioMaxReal);
    }

    static PredicateSpecification<Vivienda> filtrarPorMetros(Integer metrosMin,Integer metrosMax){
        Integer metroMinReal = metrosMin == null ? 0 : metrosMin;
        Integer metrosMaxReal = metrosMax ==  null ? 0 : metrosMax;
        return (from, criteriaBuilder) ->
                criteriaBuilder.between(from.get("metrosCuadrados"),metroMinReal,metrosMaxReal);
    }

    static PredicateSpecification<Vivienda> filtarPorHabitaciones(Integer numHabitacionesMin){
        return (from, criteriaBuilder) ->
                numHabitacionesMin == null ? criteriaBuilder.and() : criteriaBuilder.greaterThan(from.get("numHabitaciones"),numHabitacionesMin);
    }

    static PredicateSpecification<Vivienda> filtarPorBanios(Integer numBaniosMin){
        return (from, criteriaBuilder) ->
                numBaniosMin == null ? criteriaBuilder.and() : criteriaBuilder.greaterThan(from.get("banios"),numBaniosMin);
    }

    static PredicateSpecification<Vivienda> filtarPorTipoVivienda(TipoVivienda tipoVivienda){
        return (from, criteriaBuilder) ->
                tipoVivienda == null ? criteriaBuilder.and() : criteriaBuilder.equal(criteriaBuilder.lower(from.get("tipoVivienda")),tipoVivienda);
    }

    static PredicateSpecification<Vivienda> filtrarPorEstadoVivienda(EstadoVivienda estadoVivienda){
        return (from, criteriaBuilder) ->
                estadoVivienda == null ? criteriaBuilder.and() : criteriaBuilder.equal(criteriaBuilder.lower(from.get("estadoVivienda")),estadoVivienda);
    }

    static PredicateSpecification<Vivienda> filtarPorAscensor(Boolean ascensor){
        return (from, criteriaBuilder) ->
                ascensor == null ? criteriaBuilder.and() : criteriaBuilder.isTrue(from.get("ascensor"));
    }

    static  PredicateSpecification<Vivienda> filtarPorTerraza(Boolean terraza){
        return (from, criteriaBuilder) ->
                terraza == null ? criteriaBuilder.and() : criteriaBuilder.isTrue(from.get("terraza"));
    }

    static PredicateSpecification<Vivienda> filtarPorGaraje(Boolean garaje){
        return (from, criteriaBuilder) ->
                garaje == null ? criteriaBuilder.and() : criteriaBuilder.isTrue(from.get("garaje"));
    }

    static PredicateSpecification<Vivienda> filtarPorDisponible(Boolean disponible){
        return (from, criteriaBuilder) ->
                disponible == null ? criteriaBuilder.and() : criteriaBuilder.isTrue(from.get("disponible"));
    }
}
