package com.example.tsl.model.employees.baseEntity;

import com.example.tsl.enums.FormOfEmployment;
import com.example.tsl.model.address.Address;
import com.example.tsl.model.roles.EmployeeRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String telephone;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private BigDecimal basicSalary;
    private LocalDate dateOfEmployment;
    @Enumerated(EnumType.STRING)
    private FormOfEmployment formOfEmployment;
    private LocalDate contractExpiryDate;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employees_roles",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<EmployeeRole> roles = new HashSet<>();
}
