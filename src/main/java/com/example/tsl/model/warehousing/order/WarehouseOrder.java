package com.example.tsl.model.warehousing.order;

import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.warehousing.goods.Goods;
import com.example.tsl.model.warehousing.warehouse.Warehouse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WarehouseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToMany
    @JoinTable(
            name = "warehouse_order_goods",
            joinColumns = @JoinColumn(name = "warehouse_order_id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id"))
    private List<Goods> goods = new ArrayList<>();
    private LocalDate dateAdded;
    private LocalDate dateOfReturn;
    private Double totalCosts;
}
