package com.example.tsl.model.warehousing.order;

import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.warehousing.goods.Goods;
import com.example.tsl.model.warehousing.warehouse.Warehouse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

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
    @OneToMany
    @MapKey(name = "label")
    private Map<String, Goods> goods = new TreeMap<>();
    private LocalDate dateAdded;
    private LocalDate dateOfReturn;

}
