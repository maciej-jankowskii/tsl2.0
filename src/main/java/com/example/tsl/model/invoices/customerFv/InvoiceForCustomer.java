package com.example.tsl.model.invoices.customerFv;

import com.example.tsl.model.cargos.Cargo;
import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.invoices.baseEntity.Invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InvoiceForCustomer  extends Invoice {
    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
