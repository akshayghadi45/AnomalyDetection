package com.example.anomalydetection.controllers;

import com.example.anomalydetection.dtos.AnomalyAlertDto;
import com.example.anomalydetection.models.AnomalyAlert;
import com.example.anomalydetection.services.AnomalyAlertService;
import org.springframework.beans.factory.annotation.Autowired;
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
    AnomalyAlertService anomalyAlertService;

    public AnomalyAlertController(AnomalyAlertService anomalyAlertService) {
        this.anomalyAlertService = anomalyAlertService;
    }

    @GetMapping
    public ResponseEntity<List<AnomalyAlertDto>> getAllAlerts() {
        List<AnomalyAlertDto> anomalyAlertList = anomalyAlertService.getAllAlerts();
        return new ResponseEntity<>(anomalyAlertList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnomalyAlertDto> getAlertById(@PathVariable Long id) {
        AnomalyAlertDto alertById = anomalyAlertService.getAlertById(id);
        return new ResponseEntity<>(alertById, HttpStatus.OK);
    }
}
