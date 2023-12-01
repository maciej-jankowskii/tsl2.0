package com.example.tsl.model.employees.officeWorkers;

import com.example.tsl.model.employees.baseEntity.Employee;
import com.example.tsl.model.orders.forwarderOrder.ForwardingOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "forwarders")
public class Forwarder extends Employee {
    @OneToMany(mappedBy = "forwarder")
    private List<ForwardingOrder> forwardingOrders;
    private Double extraPercentage; //for example +20% above 3000 EUR per month
}
