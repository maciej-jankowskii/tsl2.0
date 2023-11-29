package com.example.tsl.model.invoices.warehouseInvoice;

import com.example.tsl.model.invoices.baseEntity.Invoice;
import com.example.tsl.model.warehousing.order.WarehouseOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class WarehouseOrderInvoice extends Invoice {
    @ManyToOne
    @JoinColumn(name = "warehouse_order_id")
    private WarehouseOrder warehouseOrder;

}
