package com.example.tsl.model.employees.officeWorkers;

import com.example.tsl.model.employees.baseEntity.Employee;
import com.example.tsl.model.orders.forwarderOrder.ForwardingOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "forwarders")
public class Forwarder extends Employee {
    @OneToMany
    @JoinTable(name = "forwarder_orders")
    private List<ForwardingOrder> forwardingOrders;
    private Double extraPercentage; //for example +20% above 3000 EUR per month
    private Double totalMargin;
}
