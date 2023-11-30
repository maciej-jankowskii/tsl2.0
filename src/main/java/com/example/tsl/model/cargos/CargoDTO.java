package com.example.tsl.model.cargos;

import com.example.tsl.enums.Currency;
import com.example.tsl.model.contractors.customer.CustomerDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CargoDTO {
    private Long id;
    private String cargoNumber;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateAdded;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate loadingDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate unloadingDate;
    private String loadingAddress;
    private String unloadingAddress;
    private String goods;
    private String description;
    private Boolean assignedToOrder;
    private Boolean invoiced;
    private CustomerDTO customerDTO;

}
