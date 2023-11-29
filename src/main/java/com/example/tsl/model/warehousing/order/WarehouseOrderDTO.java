package com.example.tsl.model.warehousing.order;


import com.example.tsl.model.contractors.customer.CustomerDTO;
import com.example.tsl.model.warehousing.warehouse.WarehouseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


@Getter
@Setter
public class WarehouseOrderDTO {
    private Long id;
    private WarehouseDTO warehouse;
    private CustomerDTO customer;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateAdded;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfReturn;
}
