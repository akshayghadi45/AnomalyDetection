package com.example.anomalydetection.services;

import com.example.anomalydetection.dtos.NetworkEventDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NetworkEventService {
    public NetworkEventDto ingestEvent(NetworkEventDto networkEventDto);
    public List<NetworkEventDto> getRecentEvents();
    public Page<NetworkEventDto> getPagedEvents(int page, int size );
}
