package com.example.tsl.model.contractors.mapper;

import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.contractors.customer.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer map(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFullName(customerDTO.getFullName());
        customer.setShortName(customerDTO.getShortName());
        customer.setVatNumber(customerDTO.getVatNumber());
        customer.setDescription(customerDTO.getDescription());
        customer.setTermOfPayment(customerDTO.getTermOfPayment());
        customer.setBalance(customerDTO.getBalance());
        return customer;
    }

    public CustomerDTO map(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setFullName(customer.getFullName());
        dto.setShortName(customer.getShortName());
        dto.setVatNumber(customer.getVatNumber());
        dto.setDescription(customer.getDescription());
        dto.setTermOfPayment(customer.getTermOfPayment());
        dto.setBalance(customer.getBalance());
        return dto;
    }
}
