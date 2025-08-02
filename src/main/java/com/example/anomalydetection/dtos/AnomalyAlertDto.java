package com.example.anomalydetection.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AnomalyAlertDto {
    private Long id;
    private Long eventId;
    private String alertType;
    private String description;
    private Instant detectedAt;

    //constructors
    public AnomalyAlertDto(){
    }

    public AnomalyAlertDto(Long id, Long eventId, String alertType, String description, Instant detectedAt){
        this.id = id;
        this.eventId = eventId;
        this.alertType = alertType;
        this.description = description;
        this.detectedAt = detectedAt;

    }
}
