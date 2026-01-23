package com.salesianostriana.dam.PastorMoleroGerman.repository;

import com.salesianostriana.dam.PastorMoleroGerman.model.Vivienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ViviendaRepository extends JpaRepository<Vivienda,Long>, JpaSpecificationExecutor<Vivienda> {


}
