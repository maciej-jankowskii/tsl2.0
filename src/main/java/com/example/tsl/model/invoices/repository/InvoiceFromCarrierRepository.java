package com.example.tsl.model.invoices.repository;

import com.example.tsl.model.invoices.carrierFv.InvoiceFromCarrier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceFromCarrierRepository extends CrudRepository<InvoiceFromCarrier, Long> {

    List<InvoiceFromCarrier> findAll();
}
