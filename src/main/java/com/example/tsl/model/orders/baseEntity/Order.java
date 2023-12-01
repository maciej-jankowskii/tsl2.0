package com.example.tsl.model.orders.baseEntity;

import com.example.tsl.enums.Currency;
import com.example.tsl.enums.OrderStatus;
import com.example.tsl.model.cargos.Cargo;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "main_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private LocalDate dateAdded;
    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Boolean isInvoiced;

}
