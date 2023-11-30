package com.example.tsl.model.contractors.baseEntity;


import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class ContractorDTO {
    private Long id;
    private String fullName;
    private String shortName;
    private String vatNumber;
    private String description;
    private Integer termOfPayment;
    private BigDecimal balance;

}
