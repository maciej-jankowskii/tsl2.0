package com.example.tsl.model.invoices.service;

import com.example.tsl.model.invoices.customerFv.InvoiceForCustomer;
import com.example.tsl.model.invoices.repository.InvoiceForCustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceForCustomerService {

    private final InvoiceForCustomerRepository invoiceForCustomerRepository;

    public InvoiceForCustomerService(InvoiceForCustomerRepository invoiceForCustomerRepository) {
        this.invoiceForCustomerRepository = invoiceForCustomerRepository;
    }

    public List<InvoiceForCustomer> findAll(){
        return invoiceForCustomerRepository.findAll();
    }
}
