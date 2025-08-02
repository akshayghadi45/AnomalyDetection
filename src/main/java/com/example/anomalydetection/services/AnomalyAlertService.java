package com.example.anomalydetection.services;

import com.example.anomalydetection.dtos.AnomalyAlertDto;

import java.util.List;

public interface AnomalyAlertService {
    public List<AnomalyAlertDto> getAllAlerts();
    public AnomalyAlertDto getAlertById(Long id);
}
