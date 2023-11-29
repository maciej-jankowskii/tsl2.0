package com.example.tsl.model.cargos;

import com.example.tsl.enums.Currency;
import com.example.tsl.model.contractors.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cargoNumber;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private LocalDate dateAdded;
    private LocalDate loadingDate;
    private LocalDate unloadingDate;
    private String loadingAddress;
    private String unloadingAddress;
    private String goods;
    private String description;
    private boolean assignedToOrder;
    private boolean invoiced;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
