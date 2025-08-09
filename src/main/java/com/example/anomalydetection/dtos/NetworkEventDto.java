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
    //private Instant timestamp;
    private String destinationPort;
    //private int sourcePort;

    //constructors
    public NetworkEventDto(){}

    public NetworkEventDto(String source_ip, String destination_ip, int packetSize, String protocol, Instant timestamp, String destinationPort) {
    this.source_ip = source_ip;
    this.destination_ip = destination_ip;
    this.packetSize = packetSize;
    this.protocol = protocol;
    this.destinationPort=destinationPort;
    //this.timestamp = timestamp;
    }
}
