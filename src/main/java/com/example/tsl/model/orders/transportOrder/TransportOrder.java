package com.example.tsl.model.orders.transportOrder;

import com.example.tsl.model.employees.officeWorkers.TransportPlanner;
import com.example.tsl.model.orders.baseEntity.Order;
import com.example.tsl.model.trucks.Truck;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transport_order")
public class TransportOrder extends Order {
    @ManyToOne
    @JoinColumn(name = "transport_planner_id")
    private TransportPlanner transportPlanner;
    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;
}
