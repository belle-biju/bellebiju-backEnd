package com.belleBiju.controllers;

import com.belleBiju.DTOs.requests.VendasRequest;
import com.belleBiju.DTOs.responses.VendasResponse;
import com.belleBiju.service.VendasService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/vendas")
@CrossOrigin("*")
public class VendasController {


    @Autowired
    private VendasService service;

    /*Metodo para salvar uma venda*/
    @PostMapping
    public ResponseEntity<VendasResponse> saveVenda(@RequestBody @Valid VendasRequest request){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createVenda(request));

    }

    /*Metodo para retornar todas as vendas realizadas*/
    @GetMapping
    public ResponseEntity<List<VendasResponse>> listAllVendas() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllVendas());
    }


}