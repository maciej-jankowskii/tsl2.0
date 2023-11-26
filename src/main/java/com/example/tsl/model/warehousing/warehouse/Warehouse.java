package com.example.tsl.model.warehousing.warehouse;

import com.example.tsl.enums.TypeOfGoods;
import com.example.tsl.model.address.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeOfGoods typeOfGoods;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private Boolean crane;
    private Boolean forklift;
    private BigDecimal storageCosts;
    private Double availableArea;
}
