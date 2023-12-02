package com.example.tsl.model.invoices.carrierFv;

import com.example.tsl.model.contractors.carrier.CarrierDTO;
import com.example.tsl.model.orders.forwarderOrder.ForwardingOrderDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class InvoiceFromCarrierDTO {
    private Long id;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private BigDecimal nettoValue;
    private BigDecimal bruttoValue;
    private Boolean isPaid;
    private ForwardingOrderDTO orderDTO;
    private CarrierDTO carrierDTO;
}
