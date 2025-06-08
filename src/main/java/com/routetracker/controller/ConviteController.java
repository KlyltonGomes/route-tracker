package com.routetracker.controller;

import com.routetracker.domain.entity.Convite;
import com.routetracker.service.ConviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/convites")
public class ConviteController {

    @Autowired
    private ConviteService conviteService;

    // Criar um novo convite (geralmente feito por um Admin)
    @PostMapping("/criar/{adminId}")
    public ResponseEntity<Convite> criarConvite(@PathVariable Long adminId) {
        Convite novo = conviteService.criarConviteParaAdmin(adminId);
        return ResponseEntity.ok(novo);
    }

    // Buscar um convite pelo código
    @GetMapping("/{codigo}")
    public ResponseEntity<Convite> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(conviteService.buscarPorCodigo(codigo));
    }

    // Verificar se convite foi usado
    @GetMapping("/{codigo}/usado")
    public ResponseEntity<Boolean> verificarUso(@PathVariable String codigo) {
        return ResponseEntity.ok(conviteService.foiUsado(codigo));
    }

    // (Opcional) Atribuir um convite a um motorista avulso
    @PostMapping("/{codigo}/atribuir/{motoristaId}")
    public ResponseEntity<?> atribuirConvite(@PathVariable String codigo, @PathVariable Long motoristaId) {
        conviteService.atribuirConviteAoMotorista(codigo, motoristaId);
        return ResponseEntity.ok("Convite atribuído com sucesso!");
    }
}
