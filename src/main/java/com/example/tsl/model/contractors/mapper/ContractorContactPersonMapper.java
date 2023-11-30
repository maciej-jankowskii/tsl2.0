package com.example.tsl.model.contractors.mapper;

import com.example.tsl.model.contractors.contactPerson.ContractorContactPerson;
import com.example.tsl.model.contractors.contactPerson.ContractorContactPersonDTO;
import org.springframework.stereotype.Service;

@Service
public class ContractorContactPersonMapper {

    public ContractorContactPerson map(ContractorContactPersonDTO dto) {
        ContractorContactPerson contactPerson = new ContractorContactPerson();
        contactPerson.setFirstName(dto.getFirstName());
        contactPerson.setLastName(dto.getLastName());
        contactPerson.setEmail(dto.getEmail());
        contactPerson.setTelephone(dto.getTelephone());
        return contactPerson;
    }

    public ContractorContactPersonDTO map(ContractorContactPerson contactPerson) {
        ContractorContactPersonDTO dto = new ContractorContactPersonDTO();
        dto.setFirstName(contactPerson.getFirstName());
        dto.setLastName(contactPerson.getLastName());
        dto.setEmail(contactPerson.getEmail());
        dto.setTelephone(contactPerson.getTelephone());
        return dto;
    }
}
