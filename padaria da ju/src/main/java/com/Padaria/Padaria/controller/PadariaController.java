package com.Padaria.Padaria.controller;

import com.Padaria.Padaria.business.PadariaService;
import com.Padaria.Padaria.infrastructure.entitys.Padaria;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/padaria")
@RequiredArgsConstructor
public class PadariaController {

    private final PadariaService padariaService;

    @PostMapping
    public ResponseEntity<Void> salvarPadaria(@RequestBody Padaria padaria) {
        padariaService.salvarPadaria(padaria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Padaria> buscarPorId(@PathVariable Long id) {
        Padaria padaria = padariaService.buscarPorId(id);
        return ResponseEntity.ok(padaria);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Padaria>> listarTodos() {
        return ResponseEntity.ok(padariaService.listarTodos());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        padariaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
