package com.example.tsl.model.invoices.repository;

import com.example.tsl.model.invoices.customerFv.InvoiceForCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceForCustomerRepository extends CrudRepository<InvoiceForCustomer, Long> {
    List<InvoiceForCustomer> findAll();
}
