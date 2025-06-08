package com.routetracker.repository;

import com.routetracker.domain.entity.ComprovanteEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComprovanteEntregaRepository extends JpaRepository<ComprovanteEntrega, Long> {
    List<ComprovanteEntrega> findByEntregaId(Long entregaId);
}
