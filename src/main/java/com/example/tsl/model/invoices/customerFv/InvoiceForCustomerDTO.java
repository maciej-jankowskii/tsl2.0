package com.example.tsl.model.invoices.customerFv;

import com.example.tsl.model.cargos.CargoDTO;
import com.example.tsl.model.contractors.customer.CustomerDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class InvoiceForCustomerDTO {
    private Long id;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private BigDecimal nettoValue;
    private BigDecimal bruttoValue;
    private Boolean isPaid;
    private CargoDTO cargoDTO;
    private CustomerDTO customerDTO;
}
