package com.routetracker.repository;

import com.routetracker.domain.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoristaRepository extends JpaRepository<Motorista,Long> {

    List<Motorista> findByAdminResponsavel_Id(Long adminId);

}
