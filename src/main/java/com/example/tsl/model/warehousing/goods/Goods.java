package com.example.tsl.model.warehousing.goods;

import com.example.tsl.enums.TypeOfGoods;
import com.example.tsl.model.warehousing.order.WarehouseOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private TypeOfGoods typeOfGoods;
    private Double quantity;
    private String label;
    private String description;
    private Double requiredArea;
    private Boolean assignedToOrder;

}
