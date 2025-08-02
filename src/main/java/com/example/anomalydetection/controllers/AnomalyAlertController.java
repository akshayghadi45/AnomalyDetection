package com.example.anomalydetection.controllers;

import com.example.anomalydetection.dtos.AnomalyAlertDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AnomalyAlertController {

    @GetMapping
    public ResponseEntity<List<AnomalyAlertDto>> getAllAlerts() {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK); //implement service
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnomalyAlertDto> getAlertById(@PathVariable Long id) {
        //service call
        return new ResponseEntity<>(new AnomalyAlertDto(), HttpStatus.OK);
    }
}
