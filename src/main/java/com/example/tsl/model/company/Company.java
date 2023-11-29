package com.example.tsl.model.company;

import com.example.tsl.model.address.Address;
import com.example.tsl.model.employees.baseEntity.Employee;
import com.example.tsl.model.trucks.Truck;
import com.example.tsl.model.warehousing.warehouse.Warehouse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String shortName;
    private String vatNumber;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany
    private List<Employee> employees = new ArrayList<>();
    @OneToMany
    private List<Warehouse> warehouses = new ArrayList<>();
    @OneToMany
    private List<Truck> trucks = new ArrayList<>();
    private BigDecimal balance;
}
