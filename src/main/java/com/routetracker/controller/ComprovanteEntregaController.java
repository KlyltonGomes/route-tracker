package com.routetracker.controller;

import com.routetracker.domain.entity.ComprovanteEntrega;
import com.routetracker.service.ComprovanteEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comprovantes")
public class ComprovanteEntregaController {

    @Autowired
    private ComprovanteEntregaService comprovanteEntregaService;

    @PostMapping("/entrega/{entregaId}")
    public ResponseEntity<ComprovanteEntrega> adicionarComprovante(
            @PathVariable Long entregaId,
            @RequestBody ComprovanteEntrega comprovante) {
        ComprovanteEntrega novo = comprovanteEntregaService.adicionarComprovante(entregaId, comprovante);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/entrega/{entregaId}")
    public ResponseEntity<List<ComprovanteEntrega>> listarPorEntrega(@PathVariable Long entregaId) {
        return ResponseEntity.ok(comprovanteEntregaService.listarPorEntrega(entregaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        comprovanteEntregaService.deletarComprovante(id);
        return ResponseEntity.noContent().build();
    }
}
