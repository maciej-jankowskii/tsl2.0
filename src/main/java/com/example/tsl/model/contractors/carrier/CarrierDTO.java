package com.example.tsl.model.contractors.carrier;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CarrierDTO {

    private Long id;
    private String fullName;
    private String shortName;
    private String vatNumber;
    private String description;
    private Integer termOfPayment;
    private BigDecimal balance;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate insuranceExpirationDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate licenceExpirationDate;
}
