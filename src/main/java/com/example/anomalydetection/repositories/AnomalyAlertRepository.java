package com.example.anomalydetection.repositories;

import com.example.anomalydetection.models.AnomalyAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnomalyAlertRepository extends JpaRepository<AnomalyAlert, Long> {
    @Override
    public AnomalyAlert save(AnomalyAlert anomalyAlert);

    @Override
    public List<AnomalyAlert> findAll();

    public Optional<AnomalyAlert> findById(Long id);

}
