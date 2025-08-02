package com.example.anomalydetection.services;

import com.example.anomalydetection.dtos.AnomalyAlertDto;
import com.example.anomalydetection.models.AnomalyAlert;
import com.example.anomalydetection.repositories.AnomalyAlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnomalyAlertServiceImpl implements AnomalyAlertService {
    AnomalyAlertRepository anomalyAlertRepository;
    public AnomalyAlertServiceImpl(AnomalyAlertRepository anomalyAlertRepository) {
        this.anomalyAlertRepository = anomalyAlertRepository;
    }
    @Override
    public List<AnomalyAlertDto> getAllAlerts() {
        List<AnomalyAlert> alerts = anomalyAlertRepository.findAll();

        return alerts.stream()
                .map(alert -> new AnomalyAlertDto(
                        alert.getId(),
                        alert.getNetworkEvent().getId(),
                        alert.getAlertType(),
                        alert.getAlertDescription(),
                        alert.getDetectedAt()
                )).collect(Collectors.toList());

    }

    @Override
    public AnomalyAlertDto getAlertById(Long id) {
        Optional<AnomalyAlert> anomalyAlertOptional = anomalyAlertRepository.findById(id);
        AnomalyAlert anomalyAlert;
        AnomalyAlertDto alertDto;
        if(anomalyAlertOptional.isPresent()) {
            anomalyAlert = anomalyAlertOptional.get();
            alertDto = new AnomalyAlertDto();
            alertDto.setId(anomalyAlert.getId());
            alertDto.setAlertType(anomalyAlert.getAlertType());
            alertDto.setDetectedAt(anomalyAlert.getDetectedAt());
            alertDto.setEventId(anomalyAlert.getNetworkEvent().getId());
            alertDto.setDescription(anomalyAlert.getAlertDescription());
            return alertDto;
        }
        else {
            throw new RuntimeException("Anomaly Alert with id " + id + " not found");
        }

    }
}
