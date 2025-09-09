package com.example.pentx.controller;

import com.example.pentx.model.CustomerRequest;
import com.example.pentx.service.CustomerRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-requests")
@CrossOrigin(origins = "*")  // Allow frontend calls
public class CustomerRequestController {

    private final CustomerRequestService service;

    public CustomerRequestController(CustomerRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerRequest> createRequest(@RequestBody CustomerRequest request) {
        return ResponseEntity.ok(service.saveRequest(request));
    }

    @GetMapping
    public ResponseEntity<List<CustomerRequest>> getAllRequests() {
        return ResponseEntity.ok(service.getAllRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerRequest> getRequestById(@PathVariable Long id) {
        CustomerRequest request = service.getRequestById(id);
        return request != null ? ResponseEntity.ok(request) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        service.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}
