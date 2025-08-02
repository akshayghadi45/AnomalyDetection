package com.example.anomalydetection.services;

import com.example.anomalydetection.dtos.NetworkEventDto;
import com.example.anomalydetection.models.NetworkEvent;

public interface AnomalyDetectionService {
    public Boolean isAnomaly(NetworkEvent networkEvent);
}
