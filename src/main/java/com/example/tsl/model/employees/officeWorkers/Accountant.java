package com.example.tsl.model.employees.officeWorkers;

import com.example.tsl.enums.TypeOfAdministrationRole;
import com.example.tsl.model.employees.baseEntity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accountants")
public class Accountant extends Employee {
    @Enumerated(EnumType.STRING)
    private TypeOfAdministrationRole typeOfRole;
}
