package com.example.tsl.model.invoices.carrierFv;

import com.example.tsl.model.contractors.carrier.Carrier;
import com.example.tsl.model.invoices.baseEntity.Invoice;
import com.example.tsl.model.orders.baseEntity.Order;
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
public class InvoiceFromCarrier extends Invoice {
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name="carrier_id")
    private Carrier carrier;
}
