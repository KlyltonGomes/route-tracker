package com.routetracker.repository;


import com.routetracker.domain.entity.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
    Plano findByNome(String nome);
}
