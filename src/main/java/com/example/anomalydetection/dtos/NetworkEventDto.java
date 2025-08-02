package com.example.anomalydetection.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class NetworkEventDto {
    private String source_ip;
    private String destination_ip;
    private int packetSize;
    private String protocol;
    private Instant timestamp;

    //constructors
    public NetworkEventDto(){}

    public NetworkEventDto(String source_ip, String destination_ip, int packetSize, String protocol, Instant timestamp) {
    this.source_ip = source_ip;
    this.destination_ip = destination_ip;
    this.packetSize = packetSize;
    this.protocol = protocol;
    this.timestamp = timestamp;
    }
}
