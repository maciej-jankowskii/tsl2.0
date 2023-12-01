package com.example.tsl.model.employees.mapper;

import com.example.tsl.model.employees.officeWorkers.Forwarder;
import com.example.tsl.model.employees.officeWorkers.ForwarderDTO;
import org.springframework.stereotype.Service;

@Service
public class ForwarderMapper {

    public Forwarder map(ForwarderDTO dto){
        Forwarder forwarder = new Forwarder();
        return forwarder;
    }

    public ForwarderDTO map(Forwarder forwarder){
        ForwarderDTO dto = new ForwarderDTO();

        return dto;
    }
}
