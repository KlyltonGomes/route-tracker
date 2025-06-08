package com.routetracker.service;

import com.routetracker.domain.entity.Admin;
import com.routetracker.domain.entity.Convite;
import com.routetracker.domain.entity.Motorista;
import com.routetracker.repository.AdminRepository;
import com.routetracker.repository.ConviteRepository;
import com.routetracker.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConviteService {

    @Autowired
    private ConviteRepository conviteRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    // Gera novo convite para um admin
    public Convite gerarConvite(Admin admin) {
        Convite convite = new Convite();
        convite.setAdmin(admin);
        convite.setCodigo(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        convite.setUtilizado(false);
        convite.setDataCriacao(LocalDateTime.now());

        return conviteRepository.save(convite);
    }

    // Cria convite a partir do ID do Admin
    public Convite criarConviteParaAdmin(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin não encontrado com ID: " + adminId));

        return gerarConvite(admin);
    }

    // Lista convites gerados por um admin
    public List<Convite> listarConvitesPorAdmin(Long adminId) {
        return conviteRepository.findByAdminId(adminId);
    }

    // Verifica se convite é válido (existe e não foi usado)
    public Optional<Convite> validarConvite(String codigo) {
        return conviteRepository.findByCodigoAndUtilizadoFalse(codigo);
    }

    // Marca um convite como utilizado
    public void marcarConviteComoUtilizado(Convite convite) {
        convite.setUtilizado(true);
        conviteRepository.save(convite);
    }

    // Busca convite por código (mesmo se for usado)
    public Convite buscarPorCodigo(String codigo) {
        return conviteRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Convite não encontrado com o código: " + codigo));
    }

    // Verifica se um convite foi utilizado
    public boolean foiUsado(String codigo) {
        Convite convite = buscarPorCodigo(codigo);
        return convite.getUtilizado();
    }

    // Atribui convite a um motorista
    public void atribuirConviteAoMotorista(String codigo, Long motoristaId) {
        Convite convite = validarConvite(codigo)
                .orElseThrow(() -> new RuntimeException("Convite inválido ou já utilizado."));

        Motorista motorista = motoristaRepository.findById(motoristaId)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado com ID: " + motoristaId));

        motorista.setConvite(convite);
        convite.setUtilizado(true); // Marca o convite como usado
        conviteRepository.save(convite);
        motoristaRepository.save(motorista);
    }
}

/*

Método	Status
gerarConvite(Admin admin)
listarConvitesPorAdmin(Long adminId)
validarConvite(String codigo)
marcarConviteComoUtilizado(Convite)
criarConviteParaAdmin(Long adminId)
buscarPorCodigo(String codigo)
foiUsado(String codigo)
atribuirConviteAoMotorista(...)
 */