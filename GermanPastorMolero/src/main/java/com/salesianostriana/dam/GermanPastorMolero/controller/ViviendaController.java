package com.salesianostriana.dam.GermanPastorMolero.controller;

import com.salesianostriana.dam.GermanPastorMolero.dto.ViviendaCreateRequest;
import com.salesianostriana.dam.GermanPastorMolero.dto.ViviendaDetails;
import com.salesianostriana.dam.GermanPastorMolero.dto.ViviendaResponse;
import com.salesianostriana.dam.GermanPastorMolero.model.Vivienda;
import com.salesianostriana.dam.GermanPastorMolero.service.ViviendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/viviendas")
public class ViviendaController {

    private final ViviendaService viviendaService;

    @GetMapping
    public ResponseEntity<Page<ViviendaResponse>> filtrar(@PageableDefault (page = 0,size = 10) Pageable pageable, ViviendaDetails viviendaDetails){
        return ResponseEntity.ok(
                viviendaService.filtarTodo(pageable,viviendaDetails).map(ViviendaResponse::viviendaResponse)
        );
    }

    @PostMapping
    public ResponseEntity<ViviendaResponse> crearVivienda(@Valid ViviendaCreateRequest viviendaCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ViviendaResponse.
                viviendaResponse(viviendaService.crearVivienda(viviendaCreateRequest)));
    }
}
