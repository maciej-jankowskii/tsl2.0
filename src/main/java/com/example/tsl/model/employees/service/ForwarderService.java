package com.example.tsl.model.employees.service;

import com.example.tsl.model.employees.officeWorkers.Forwarder;
import com.example.tsl.model.employees.repository.ForwarderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForwarderService {
    private final ForwarderRepository forwarderRepository;

    public ForwarderService(ForwarderRepository forwarderRepository) {
        this.forwarderRepository = forwarderRepository;
    }

    public Optional<Forwarder> findByEmail(String email){
        return forwarderRepository.findForwarderByEmail(email);
    }
}
