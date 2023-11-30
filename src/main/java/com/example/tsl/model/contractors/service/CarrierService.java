package com.example.tsl.model.contractors.service;

import com.example.tsl.model.address.Address;
import com.example.tsl.model.address.AddressDTO;
import com.example.tsl.model.address.AddressMapper;
import com.example.tsl.model.address.AddressRepository;
import com.example.tsl.model.contractors.carrier.Carrier;
import com.example.tsl.model.contractors.carrier.CarrierDTO;
import com.example.tsl.model.contractors.contactPerson.ContractorContactPerson;
import com.example.tsl.model.contractors.contactPerson.ContractorContactPersonDTO;
import com.example.tsl.model.contractors.mapper.CarrierMapper;
import com.example.tsl.model.contractors.mapper.ContractorContactPersonMapper;
import com.example.tsl.model.contractors.repository.CarrierRepository;
import com.example.tsl.model.contractors.repository.ContractorContactPersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class CarrierService {
    private final CarrierRepository carrierRepository;
    private final CarrierMapper carrierMapper;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;
    private final ContractorContactPersonMapper contractorContactPersonMapper;
    private final ContractorContactPersonRepository contractorContactPersonRepository;

    public CarrierService(CarrierRepository carrierRepository, CarrierMapper carrierMapper, AddressMapper addressMapper, AddressRepository addressRepository, ContractorContactPersonMapper contractorContactPersonMapper, ContractorContactPersonRepository contractorContactPersonRepository) {
        this.carrierRepository = carrierRepository;
        this.carrierMapper = carrierMapper;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
        this.contractorContactPersonMapper = contractorContactPersonMapper;
        this.contractorContactPersonRepository = contractorContactPersonRepository;
    }

    public List<Carrier> findAll() {
        return carrierRepository.findAll();
    }

    @Transactional
    public CarrierDTO addCarrier(CarrierDTO carrierDTO, AddressDTO addressDTO, ContractorContactPersonDTO contactPersonDTO) {
        Carrier carrier = carrierMapper.map(carrierDTO);
        Address address = addressMapper.map(addressDTO);
        ContractorContactPerson contactPerson = contractorContactPersonMapper.map(contactPersonDTO);

        addAdditionalDataForCarrier(carrier, address, contactPerson);
        saveAdditionalDataForCarrier(address, contactPerson);

        Carrier saved = carrierRepository.save(carrier);
        return carrierMapper.map(saved);
    }

    private void saveAdditionalDataForCarrier(Address address, ContractorContactPerson contactPerson) {
        addressRepository.save(address);
        contractorContactPersonRepository.save(contactPerson);
    }

    private static void addAdditionalDataForCarrier(Carrier carrier, Address address, ContractorContactPerson contactPerson) {
        carrier.setAddress(address);
        carrier.setContactPersons(Collections.singletonList(contactPerson));
        carrier.setBalance(BigDecimal.ZERO);
        contactPerson.setContractor(carrier);
    }
}
