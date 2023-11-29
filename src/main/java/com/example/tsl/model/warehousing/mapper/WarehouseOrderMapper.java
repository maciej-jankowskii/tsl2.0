package com.example.tsl.model.warehousing.mapper;

import com.example.tsl.model.warehousing.order.WarehouseOrder;
import com.example.tsl.model.warehousing.order.WarehouseOrderDTO;
import org.springframework.stereotype.Service;

@Service
public class WarehouseOrderMapper {

    public WarehouseOrder map(WarehouseOrderDTO dto) {
        WarehouseOrder warehouseOrder = new WarehouseOrder();
        warehouseOrder.setDateAdded(dto.getDateAdded());
        warehouseOrder.setDateOfReturn(dto.getDateOfReturn());
        return warehouseOrder;
    }

    public WarehouseOrderDTO map(WarehouseOrder order) {
        WarehouseOrderDTO dto = new WarehouseOrderDTO();
        dto.setDateAdded(order.getDateAdded());
        dto.setDateOfReturn(order.getDateOfReturn());
        return dto;
    }
}
