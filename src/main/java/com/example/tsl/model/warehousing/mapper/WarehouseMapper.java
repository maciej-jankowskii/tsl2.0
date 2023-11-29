package com.example.tsl.model.warehousing.mapper;

import com.example.tsl.enums.TypeOfGoods;
import com.example.tsl.model.warehousing.warehouse.Warehouse;
import com.example.tsl.model.warehousing.warehouse.WarehouseDTO;
import org.springframework.stereotype.Service;

@Service
public class WarehouseMapper {

    public Warehouse map (WarehouseDTO warehouseDTO){
        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseDTO.getId());
        warehouse.setTypeOfGoods(TypeOfGoods.valueOf(warehouseDTO.getTypeOfGoods()));
        warehouse.setCrane(warehouseDTO.getCrane());
        warehouse.setForklift(warehouseDTO.getForklift());
        warehouse.setAvailableArea(warehouseDTO.getAvailableArea());
        warehouse.setCostPer100SquareMeters(warehouseDTO.getCostPer100SquareMeters());
        return warehouse;
    }

    public WarehouseDTO map(Warehouse warehouse){
        WarehouseDTO dto = new WarehouseDTO();
        dto.setId(warehouse.getId());
        dto.setTypeOfGoods(String.valueOf(warehouse.getTypeOfGoods()));
        dto.setCostPer100SquareMeters(warehouse.getCostPer100SquareMeters());
        dto.setAvailableArea(warehouse.getAvailableArea());
        dto.setCrane(warehouse.getCrane());
        dto.setForklift(warehouse.getForklift());
        return dto;
    }
}
