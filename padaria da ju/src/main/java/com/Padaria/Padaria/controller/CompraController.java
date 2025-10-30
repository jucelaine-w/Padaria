package com.Padaria.Padaria.controller;

import com.Padaria.Padaria.DTO.CompraDTO;
import com.Padaria.Padaria.business.CompraService;
import com.Padaria.Padaria.infrastructure.entitys.Compra;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
    @RestController
    @RequestMapping("/compas")
    public class CompraController {
        private final CompraService compraService;

        public CompraController(CompraService compraService) {
            this.compraService = compraService;
        }
        @PostMapping
        public ResponseEntity<Compra> CriarCompra(@RequestBody CompraDTO dto) {
            Compra novaCompra=compraService.criarCompraComDTO(dto);
            return ResponseEntity.ok(novaCompra);
        }
    }

