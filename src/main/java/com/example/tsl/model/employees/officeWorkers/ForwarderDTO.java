package com.example.tsl.model.employees.officeWorkers;

import com.example.tsl.enums.FormOfEmployment;
import com.example.tsl.model.address.AddressDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ForwarderDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String telephone;
    private AddressDTO address;
    private BigDecimal basicBruttoSalary;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfEmployment;
    @Enumerated(EnumType.STRING)
    private FormOfEmployment formOfEmployment;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate contractExpiryDate;
    private Double extraPercentage;
}
