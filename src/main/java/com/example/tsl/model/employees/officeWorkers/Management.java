package com.example.tsl.model.employees.officeWorkers;

import com.example.tsl.enums.ManagementRole;
import com.example.tsl.model.employees.baseEntity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Management extends Employee {
    @Enumerated(EnumType.STRING)
    private ManagementRole managementRole;
}
