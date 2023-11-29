package com.example.tsl.model.warehousing.service;

import com.example.tsl.model.address.Address;
import com.example.tsl.model.address.AddressDTO;
import com.example.tsl.model.address.AddressMapper;
import com.example.tsl.model.address.AddressRepository;
import com.example.tsl.model.warehousing.mapper.WarehouseMapper;
import com.example.tsl.model.warehousing.repository.WarehouseRepository;
import com.example.tsl.model.warehousing.warehouse.Warehouse;
import com.example.tsl.model.warehousing.warehouse.WarehouseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;
    private final CostCalculatorService costCalculatorService;

    public WarehouseService(WarehouseRepository warehouseRepository, WarehouseMapper warehouseMapper, AddressMapper addressMapper, AddressRepository addressRepository, CostCalculatorService costCalculatorService) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseMapper = warehouseMapper;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
        this.costCalculatorService = costCalculatorService;
    }

    public List<Warehouse> findAll(){
        return warehouseRepository.findAll();
    }

    @Transactional
    public WarehouseDTO addWarehouse(WarehouseDTO warehouseDTO, AddressDTO addressDTO){
        Address address = addressMapper.map(addressDTO);
        Warehouse warehouse = warehouseMapper.map(warehouseDTO);
        addressRepository.save(address);
        warehouse.setAddress(address);
        Warehouse saved = warehouseRepository.save(warehouse);
        return warehouseMapper.map(saved);

    }
}
