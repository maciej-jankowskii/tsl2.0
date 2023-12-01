package com.example.tsl.model.orders.forwarderOrder;

import com.example.tsl.enums.TypeOfTruck;
import com.example.tsl.model.contractors.carrier.Carrier;
import com.example.tsl.model.employees.officeWorkers.Forwarder;
import com.example.tsl.model.orders.baseEntity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "forwarding_order")
public class ForwardingOrder extends Order {

    @ManyToOne
    @JoinColumn(name = "forwarder_id")
    private Forwarder forwarder;
    @ManyToOne
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;
    @Enumerated(EnumType.STRING)
    private TypeOfTruck typeOfTruck;
    private String truckNumbers;
    private BigDecimal margin;
}
