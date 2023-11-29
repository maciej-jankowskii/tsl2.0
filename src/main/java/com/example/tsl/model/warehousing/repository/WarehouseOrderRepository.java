package com.example.tsl.model.warehousing.repository;

import com.example.tsl.model.warehousing.order.WarehouseOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseOrderRepository extends CrudRepository<WarehouseOrder, Long> {
    List<WarehouseOrder> findAll();
}
