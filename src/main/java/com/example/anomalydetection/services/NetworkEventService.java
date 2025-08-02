package com.example.anomalydetection.services;

import com.example.anomalydetection.dtos.NetworkEventDto;

import java.util.List;

public interface NetworkEventService {
    public NetworkEventDto ingestEvent(NetworkEventDto networkEventDto);
    public List<NetworkEventDto> getRecentEvents();
}
