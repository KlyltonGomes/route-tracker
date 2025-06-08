package com.routetracker.service;

import com.routetracker.domain.entity.ComprovanteEntrega;
import com.routetracker.domain.entity.Entrega;
import com.routetracker.repository.ComprovanteEntregaRepository;
import com.routetracker.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComprovanteEntregaService {

    @Autowired
    private ComprovanteEntregaRepository comprovanteEntregaRepository;

    @Autowired
    private EntregaRepository entregaRepository;

    public ComprovanteEntrega adicionarComprovante(Long entregaId, ComprovanteEntrega comprovante) {
        Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));

        comprovante.setEntrega(entrega);
        comprovante.setDataEnvio(LocalDateTime.now());
        return comprovanteEntregaRepository.save(comprovante);
    }

    public List<ComprovanteEntrega> listarPorEntrega(Long entregaId) {
        return comprovanteEntregaRepository.findByEntregaId(entregaId);
    }

    public void deletarComprovante(Long id) {
        comprovanteEntregaRepository.deleteById(id);
    }
}
