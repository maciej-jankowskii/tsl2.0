package com.example.tsl.model.invoices.service;

import com.example.tsl.model.invoices.carrierFv.InvoiceFromCarrier;
import com.example.tsl.model.invoices.repository.InvoiceFromCarrierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceFromCarrierService {

    private final InvoiceFromCarrierRepository invoiceFromCarrierRepository;

    public InvoiceFromCarrierService(InvoiceFromCarrierRepository invoiceFromCarrierRepository) {
        this.invoiceFromCarrierRepository = invoiceFromCarrierRepository;
    }

    public List<InvoiceFromCarrier> findAll(){
        return invoiceFromCarrierRepository.findAll();
    }
}
