package com.example.anomalydetection.services;

import com.example.anomalydetection.dtos.NetworkEventDto;
import com.example.anomalydetection.models.AnomalyAlert;
import com.example.anomalydetection.models.NetworkEvent;
import com.example.anomalydetection.repositories.AnomalyAlertRepository;
import com.example.anomalydetection.repositories.NetworkEventRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NetworkEventServiceImpl implements NetworkEventService {

    NetworkEventRepository networkEventRepository;
    AnomalyAlertRepository anomalyAlertRepository;
    AnomalyDetectionService anomalyDetectionService;

    NetworkEventServiceImpl(NetworkEventRepository networkEventRepository,  AnomalyAlertRepository anomalyAlertRepository) {
        this.networkEventRepository = networkEventRepository;
        this.anomalyAlertRepository = anomalyAlertRepository;
    }

    @Override
    public NetworkEventDto ingestEvent(NetworkEventDto networkEventDto) {
        // Convert DTO to entity
        NetworkEvent event = new NetworkEvent();
        event.setSource_ip(networkEventDto.getSource_ip());
        event.setDestination_ip(networkEventDto.getDestination_ip());
        event.setTimestamp(networkEventDto.getTimestamp());
        event.setPacket_size(networkEventDto.getPacketSize());
        event.setProtocol(networkEventDto.getProtocol());
        event.setTimestamp(networkEventDto.getTimestamp()!=null?networkEventDto.getTimestamp(): Instant.now());

        //persist event
        NetworkEvent savedNetworkEvent =networkEventRepository.save(event);

        //run anomaly detection
        if(anomalyDetectionService.isAnomaly(savedNetworkEvent)){
            //create anomaly event and save it
            AnomalyAlert anomalyAlert = new AnomalyAlert();;
            anomalyAlert.setNetworkEvent(savedNetworkEvent);
            anomalyAlert.setAlertType("Suspicious Activity");
            anomalyAlert.setAlertDescription("Anomaly detected in network event");
            anomalyAlert.setDetectedAt(Instant.now());
            anomalyAlertRepository.save(anomalyAlert);
        }
        return networkEventDto;
    }

    @Override
    public List<NetworkEventDto> getRecentEvents() {
        List<NetworkEvent> networkEventList =networkEventRepository.findTop50ByOrderByTimestampDesc();
        return networkEventList.stream()
                .map(networkEvent -> new NetworkEventDto(
                        networkEvent.getSource_ip(),
                        networkEvent.getDestination_ip(),
                        networkEvent.getPacket_size(),
                        networkEvent.getProtocol(),
                        networkEvent.getTimestamp()

                ))
                .collect(Collectors.toList());
    }
}
