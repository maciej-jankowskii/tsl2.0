package com.example.tsl.model.contractors.service;

import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.contractors.mapper.CustomerMapper;
import com.example.tsl.model.contractors.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
