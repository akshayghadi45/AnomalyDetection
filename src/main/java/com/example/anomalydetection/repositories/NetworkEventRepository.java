package com.example.anomalydetection.repositories;

import com.example.anomalydetection.controllers.NetworkEventController;
import com.example.anomalydetection.models.NetworkEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NetworkEventRepository extends JpaRepository<NetworkEvent, Long> {
    @Override
    public NetworkEvent save(NetworkEvent networkEvent);

    @Override
    public List<NetworkEvent> findAll();

    List<NetworkEvent> findTop50ByOrderByTimestampDesc();
}
