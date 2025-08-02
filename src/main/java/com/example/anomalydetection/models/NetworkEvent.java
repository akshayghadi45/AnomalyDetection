package com.example.anomalydetection.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name="network_events")
public class NetworkEvent extends Base{

    @Column(nullable=false)
    private String source_ip;

    @Column(nullable=false)
    private String destination_ip;

    @Column(nullable=false)
    private int packet_size;

    @Column(nullable=false)
    private String protocol;

    @Column(nullable=false)
    private String destination_port;

    @Column(nullable=false)
    private Instant timestamp;
}
