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

     static PredicateSpecification<Vivienda> filtrarPorAscensor(){
        return (from, builder) ->
                builder.isTrue(from.get("ascensor"));
    }
     static PredicateSpecification<Vivienda> filtrarPorTerraza(){
        return (from, builder) ->
                builder.isTrue(from.get("terraza"));
    }

     static PredicateSpecification<Vivienda> filtarPorGarage(){
        return (from, builder) ->
                builder.isTrue(from.get("garage"));
    }

     static PredicateSpecification<Vivienda> filtarPorPrecio(Integer precioMax, Integer precioMin){
         Double precioMaxReal = precioMax == null ? precioMax : Double.POSITIVE_INFINITY;
         Double precioMinReal = precioMin == null ? precioMin : Double.NEGATIVE_INFINITY ;
         return (from, criteriaBuilder) ->
                 criteriaBuilder.between(from.get("precio"),precioMinReal,precioMaxReal);
     }


}
