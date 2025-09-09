package com.example.pentx.service;

import com.example.pentx.model.CustomerRequest;
import com.example.pentx.repository.CustomerRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRequestService {

    private final CustomerRequestRepository repository;

    public CustomerRequestService(CustomerRequestRepository repository) {
        this.repository = repository;
    }

    public CustomerRequest saveRequest(CustomerRequest request) {
        return repository.save(request);
    }

    public List<CustomerRequest> getAllRequests() {
        return repository.findAll();
    }

    public CustomerRequest getRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}
