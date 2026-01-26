package com.salesianostriana.dam.PastorMoleroGerman.controller;


import com.salesianostriana.dam.PastorMoleroGerman.dto.ViviendaDatails;
import com.salesianostriana.dam.PastorMoleroGerman.dto.ViviendaResponse;
import com.salesianostriana.dam.PastorMoleroGerman.service.ViviendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class ViviendaController {

    private final ViviendaService viviendaService;

    public ResponseEntity<Page<ViviendaResponse>> filtar(@PageableDefault (page = 0, size = 10) Pageable pageable, ViviendaDatails viviendaDatails){
        return ResponseEntity.ok(
                viviendaService.filtar(pageable,viviendaDatails).map(ViviendaResponse::viviendaResponse)
        );
    }

}
