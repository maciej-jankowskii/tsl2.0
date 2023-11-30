package com.example.tsl.model.contractors.service;

import com.example.tsl.model.address.Address;
import com.example.tsl.model.address.AddressDTO;
import com.example.tsl.model.address.AddressMapper;
import com.example.tsl.model.address.AddressRepository;
import com.example.tsl.model.contractors.contactPerson.ContractorContactPerson;
import com.example.tsl.model.contractors.contactPerson.ContractorContactPersonDTO;
import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.contractors.customer.CustomerDTO;
import com.example.tsl.model.contractors.mapper.ContractorContactPersonMapper;
import com.example.tsl.model.contractors.mapper.CustomerMapper;
import com.example.tsl.model.contractors.repository.ContractorContactPersonRepository;
import com.example.tsl.model.contractors.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AddressMapper addressMapper;
    private final ContractorContactPersonMapper contractorContactPersonMapper;
    private final AddressRepository addressRepository;
    private final ContractorContactPersonRepository contractorContactPersonRepository;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper, AddressMapper addressMapper, ContractorContactPersonMapper contractorContactPersonMapper, AddressRepository addressRepository, ContractorContactPersonRepository contractorContactPersonRepository) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.addressMapper = addressMapper;
        this.contractorContactPersonMapper = contractorContactPersonMapper;
        this.addressRepository = addressRepository;
        this.contractorContactPersonRepository = contractorContactPersonRepository;
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Transactional
    public CustomerDTO addCustomer(CustomerDTO customerDTO, AddressDTO addressDTO, ContractorContactPersonDTO contactPersonDTO) {
        Customer customer = customerMapper.map(customerDTO);
        Address address = addressMapper.map(addressDTO);
        ContractorContactPerson contactPerson = contractorContactPersonMapper.map(contactPersonDTO);

        addAdditionalDataFroCustomer(customer, address, contactPerson);
        saveAdditionalDataForCustomer(address, contactPerson);

        Customer saved = customerRepository.save(customer);
        return customerMapper.map(saved);
    }

    private static void addAdditionalDataFroCustomer(Customer customer, Address address, ContractorContactPerson contactPerson) {
        customer.setAddress(address);
        customer.setContactPersons(Collections.singletonList(contactPerson));
        customer.setBalance(BigDecimal.ZERO);
        contactPerson.setContractor(customer);
    }

    private void saveAdditionalDataForCustomer(Address address, ContractorContactPerson contactPerson) {
        addressRepository.save(address);
        contractorContactPersonRepository.save(contactPerson);
    }
}
