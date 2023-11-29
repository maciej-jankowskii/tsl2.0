package com.example.tsl.model.contractors.customer;

import com.example.tsl.enums.PaymentsRating;
import com.example.tsl.model.cargos.Cargo;
import com.example.tsl.model.contractors.baseEntity.Contractor;
import com.example.tsl.model.invoices.customerFv.InvoiceForCustomer;
import com.example.tsl.model.warehousing.order.WarehouseOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends Contractor {
    @OneToMany(mappedBy = "customer")
    private List<Cargo> cargos = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private PaymentsRating paymentsRating;
    @OneToMany(mappedBy = "customer")
    private List<WarehouseOrder> warehouseOrders = new ArrayList<>();
    @OneToMany(mappedBy = "customer")
    private List<InvoiceForCustomer> customerInvoices = new ArrayList<>();
}
