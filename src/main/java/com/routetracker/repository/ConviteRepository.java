package com.routetracker.repository;

import com.routetracker.domain.entity.Convite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConviteRepository extends JpaRepository<Convite, Long> {
    List<Convite> findByAdminId(Long adminId);
    Optional<Convite> findByCodigoAndUtilizadoFalse(String codigo);
    Optional<Convite> findByCodigo(String codigo);
}
