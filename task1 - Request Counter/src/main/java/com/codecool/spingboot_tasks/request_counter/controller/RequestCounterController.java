package com.codecool.spingboot_tasks.request_counter.controller;

import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RequestCounterController {

    private final List<String> shoppingCart;

    private final RequestCountStatsService service;

    @Autowired
    public RequestCounterController(RequestCountStatsService service) throws InterruptedException {
        this.shoppingCart = new ArrayList<>();
        this.service = service;
    }

    @GetMapping("/api/requests")
    public ResponseEntity<Void> get() throws Exception {
        service.increaseCounter(RequestCountStatsService.GET);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/requests")
    public ResponseEntity<Void> post() throws Exception {
        service.increaseCounter(RequestCountStatsService.POST);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/requests")
    public ResponseEntity<Void> put() throws Exception {
        service.increaseCounter(RequestCountStatsService.PUT);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/requests")
    public ResponseEntity<Void> delete() throws Exception {
        service.increaseCounter(RequestCountStatsService.DELETE);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/requests")
    public ResponseEntity<Void> patch() throws Exception {
        service.increaseCounter(RequestCountStatsService.PATCH);
        return ResponseEntity.ok().build();
    }

}