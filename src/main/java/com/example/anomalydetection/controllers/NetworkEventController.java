package com.example.anomalydetection.controllers;

import com.example.anomalydetection.dtos.NetworkEventDto;
import com.example.anomalydetection.services.NetworkEventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class NetworkEventController {

    NetworkEventService networkEventService;
    NetworkEventController(NetworkEventService networkEventService) {
        this.networkEventService = networkEventService;
    }

    @PostMapping
    public ResponseEntity<NetworkEventDto> ingestEvent(@RequestBody NetworkEventDto dto){
        NetworkEventDto networkEventDto = networkEventService.ingestEvent(dto);
        return new ResponseEntity<>(networkEventDto, HttpStatus.OK);//implement service
    }

    //events without paging -> converted to paging using below method
//    @GetMapping
//    public ResponseEntity<List<NetworkEventDto>> getRecentEvents(){
//        List<NetworkEventDto> recentEvents = networkEventService.getRecentEvents();
//        return new ResponseEntity<>(recentEvents, HttpStatus.OK); //implement service
//    }

    @GetMapping
    public Page<NetworkEventDto> getPagedEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size)
    {
        return networkEventService.getPagedEvents(page, size);
    }
}
