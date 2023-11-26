package com.example.tsl.model.employees.officeWorkers;

import com.example.tsl.model.employees.baseEntity.Employee;
import com.example.tsl.model.orders.transportOrder.TransportOrder;
import com.example.tsl.model.trucks.Truck;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transport_planners")
public class TransportPlanner extends Employee {
    @OneToMany
    private List<Truck> companyTrucks;
    @OneToMany
    private List<TransportOrder> transportOrders;
    private Double salaryBonus;  // + for example 600PLN per truck
}
