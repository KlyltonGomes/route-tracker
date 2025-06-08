package com.routetracker.service;

import com.routetracker.domain.entity.Entrega;
import com.routetracker.domain.entity.Motorista;
import com.routetracker.domain.enums.StatusEntrega;
import com.routetracker.repository.EntregaRepository;
import com.routetracker.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    public Entrega criarEntrega(Long motoristaId, Entrega entrega) {
        Motorista motorista = motoristaRepository.findById(motoristaId)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));

        entrega.setMotorista(motorista);
        entrega.setInicioEntrega(LocalDateTime.now());
        entrega.setStatusEntrega(StatusEntrega.EM_TRANSITO); // status inicial
        return entregaRepository.save(entrega);
    }

    public List<Entrega> listarPorMotorista(Long motoristaId) {
        return entregaRepository.findByMotoristaId(motoristaId);
    }

    public Entrega finalizarEntrega(Long entregaId, String observacao, Double quilometragem) {
        Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));

        entrega.setFinalEntrega(LocalDateTime.now());
        entrega.setStatusEntrega(StatusEntrega.ENTREGUE);
        entrega.setObservacao(observacao);
        entrega.setQuilometragemPercorrida(quilometragem);

        return entregaRepository.save(entrega);
    }
}
