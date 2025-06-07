package com.routetracker.repository;

import com.routetracker.domain.entity.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessoRepositoy extends JpaRepository<Acesso,Long> {
}
