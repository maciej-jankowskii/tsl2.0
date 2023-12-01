package com.example.tsl.model.orders.forwarderOrder;

import com.example.tsl.enums.Currency;
import com.example.tsl.enums.OrderStatus;
import com.example.tsl.enums.TypeOfTruck;
import com.example.tsl.model.cargos.CargoDTO;
import com.example.tsl.model.contractors.carrier.CarrierDTO;
import com.example.tsl.model.employees.officeWorkers.ForwarderDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ForwardingOrderDTO {
    private Long id;
    private String orderNumber;
    private LocalDate dateAdded;
    private CargoDTO cargo;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Boolean isInvoiced;
    private ForwarderDTO forwarder;
    private CarrierDTO carrier;
    @Enumerated(EnumType.STRING)
    private TypeOfTruck typeOfTruck;
    private String truckNumbers;
    private BigDecimal margin;
}
