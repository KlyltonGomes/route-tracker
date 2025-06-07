package com.routetracker.service;

import com.routetracker.domain.entity.Plano;
import com.routetracker.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public Plano criarPlano(Plano plano) {
        return planoRepository.save(plano);
    }

    public List<Plano> listarPlanos() {
        return planoRepository.findAll();
    }

    public Plano buscarPorId(Long id) {
        return planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));
    }

    public Plano buscarPorNome(String nome) {
        return planoRepository.findByNome(nome);
    }

    public void excluirPlano(Long id) {
        planoRepository.deleteById(id);
    }
}
