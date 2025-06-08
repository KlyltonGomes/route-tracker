package com.routetracker.controller;

import com.routetracker.domain.entity.Entrega;
import com.routetracker.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping("/motorista/{id}")
    public ResponseEntity<Entrega> criar(@PathVariable Long id, @RequestBody Entrega entrega) {
        Entrega nova = entregaService.criarEntrega(id, entrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    @GetMapping("/motorista/{id}")
    public ResponseEntity<List<Entrega>> listarPorMotorista(@PathVariable Long id) {
        return ResponseEntity.ok(entregaService.listarPorMotorista(id));
    }

    @PutMapping("/{id}/finalizar")
    public ResponseEntity<Entrega> finalizar(
            @PathVariable Long id,
            @RequestParam(required = false) String observacao,
            @RequestParam Double quilometragem
    ) {
        return ResponseEntity.ok(entregaService.finalizarEntrega(id, observacao, quilometragem));
    }
}
