package com.example.tsl.model.trucks;

import com.example.tsl.enums.TypeOfTruck;
import com.example.tsl.model.employees.manualWorkers.Driver;
import com.example.tsl.model.employees.officeWorkers.TransportPlanner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "trucks")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    @Enumerated(EnumType.STRING)
    private TypeOfTruck type;
    private String plates;
    private LocalDate technicalInspectionDate;
    private LocalDate insuranceDate;
    private Boolean assignedToDriver;
    @OneToMany(mappedBy = "truck")
    private List<Driver> drivers = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "transport_planner_id")
    private TransportPlanner transportPlanner;
}
