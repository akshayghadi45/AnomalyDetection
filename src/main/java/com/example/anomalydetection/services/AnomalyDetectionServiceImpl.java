package com.example.anomalydetection.services;

import com.example.anomalydetection.models.NetworkEvent;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Set;

@Service
public class AnomalyDetectionServiceImpl implements AnomalyDetectionService {
    @Override
    public Boolean isAnomaly(NetworkEvent networkEvent) {
        return isLargePacket(networkEvent)
                ||isSuspiciousProtocol(networkEvent)
                ||isBlackListedSourceIp(networkEvent)
                ||isOutOfBusinessHours(networkEvent);
    }

    private  Boolean isLargePacket(NetworkEvent networkEvent) {
        //flag protocols larger as suspicious
        return networkEvent.getPacket_size()>1048576;
    }

    private Boolean isSuspiciousProtocol(NetworkEvent event) {
        //flag unknown or uncommon protocols
        final Set<String> allowedProtocols = Set.of("TCP", "UDP", "ICMP");
        return !allowedProtocols.contains(event.getProtocol().toUpperCase());
    }

    private Boolean isBlackListedSourceIp(NetworkEvent networkEvent) {
        //flag the blacklisted ip's
        final Set<String> blackListedIps = Set.of("192.168.10.10","10.0.0.99");
        return !blackListedIps.contains(networkEvent.getSource_ip());
    }
    private Boolean isOutOfBusinessHours(NetworkEvent networkEvent) {
        //flag events outside of working window
        int hour = networkEvent.getTimestamp().atZone(ZoneId.systemDefault()).getHour();
        return (hour<8 || hour>18);
    }
}
