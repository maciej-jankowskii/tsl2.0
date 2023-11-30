package com.example.tsl.model.contractors.service;

import com.example.tsl.model.contractors.contactPerson.ContractorContactPerson;
import com.example.tsl.model.contractors.mapper.ContractorContactPersonMapper;
import com.example.tsl.model.contractors.repository.ContractorContactPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractorContactPersonService {
    private final ContractorContactPersonRepository contractorContactPersonRepository;
    private final ContractorContactPersonMapper contractorContactPersonMapper;

    public ContractorContactPersonService(ContractorContactPersonRepository contractorContactPersonRepository, ContractorContactPersonMapper contractorContactPersonMapper) {
        this.contractorContactPersonRepository = contractorContactPersonRepository;
        this.contractorContactPersonMapper = contractorContactPersonMapper;
    }

    public List<ContractorContactPerson> findAll(){
        return contractorContactPersonRepository.findAll();
    }

    public List<ContractorContactPerson> findAllByContractorId(Long id){
        return contractorContactPersonRepository.findAllByContractorId(id);
    }
}
