package com.example.anomalydetection.controllers;

import com.example.anomalydetection.dtos.NetworkEventDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class NetworkEventController {

    @PostMapping
    public ResponseEntity<NetworkEventDto> ingestEvent(@RequestBody NetworkEventDto dto){

        return new ResponseEntity<>(dto, HttpStatus.OK);//implement service
    }

    @GetMapping
    public ResponseEntity<List<NetworkEventDto>> getRecentEvents(){

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK); //implement service
    }
}
