package com.example.anomalydetection.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "anomaly_alerts")
public class AnomalyAlert extends Base{

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id")
    private NetworkEvent networkEvent;

    @Column(nullable = false)
    private String alertType;

    @Column(nullable = false)
    private String alertDescription;

    @Column(nullable = false)
    private Instant detectedAt;

}
