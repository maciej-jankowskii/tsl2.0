package com.example.tsl.model.warehousing.service;

import com.example.tsl.model.warehousing.order.WarehouseOrder;


public interface StorageCostCalculator {
    Double calculateStorageCosts(WarehouseOrder warehouseOrder);
}
