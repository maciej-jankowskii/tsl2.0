package com.example.tsl.model.employees.manualWorkers;

import com.example.tsl.model.employees.baseEntity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WarehouseWorker extends Employee {
    Boolean permissionsForklift;
    Boolean permissionsCrane;
}
