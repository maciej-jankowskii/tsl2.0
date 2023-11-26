package com.example.tsl.model.employees.manualWorkers;

import com.example.tsl.enums.AdditionalRights;
import com.example.tsl.model.employees.baseEntity.Employee;
import com.example.tsl.model.trucks.Truck;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Driver extends Employee {

    private String driverLicenceNumber;
    private String licenceExpiryDate;
    private String workSystem;
    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;
    private Boolean assignedToTruck;
    @Enumerated(EnumType.STRING)
    private AdditionalRights additionalRights;
    private Boolean mainDriver;
}
