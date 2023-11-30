package com.example.tsl.model.warehousing.service;

import com.example.tsl.enums.TypeOfGoods;
import com.example.tsl.exceptions.*;
import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.contractors.repository.CustomerRepository;
import com.example.tsl.model.warehousing.goods.Goods;
import com.example.tsl.model.warehousing.mapper.WarehouseOrderMapper;
import com.example.tsl.model.warehousing.order.WarehouseOrder;
import com.example.tsl.model.warehousing.order.WarehouseOrderDTO;
import com.example.tsl.model.warehousing.repository.GoodsRepository;
import com.example.tsl.model.warehousing.repository.WarehouseOrderRepository;
import com.example.tsl.model.warehousing.repository.WarehouseRepository;
import com.example.tsl.model.warehousing.warehouse.Warehouse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class WarehouseOrderService {
    private final WarehouseOrderRepository warehouseOrderRepository;
    private final WarehouseOrderMapper warehouseOrderMapper;
    private final WarehouseRepository warehouseRepository;
    private final CustomerRepository customerRepository;
    private final GoodsRepository goodsRepository;
    private final CostCalculatorService costCalculatorService;

    public WarehouseOrderService(WarehouseOrderRepository warehouseOrderRepository, WarehouseOrderMapper warehouseOrderMapper,
                                 WarehouseRepository warehouseRepository, CustomerRepository customerRepository,
                                 GoodsRepository goodsRepository, CostCalculatorService costCalculatorService) {
        this.warehouseOrderRepository = warehouseOrderRepository;
        this.warehouseOrderMapper = warehouseOrderMapper;
        this.warehouseRepository = warehouseRepository;
        this.customerRepository = customerRepository;
        this.goodsRepository = goodsRepository;
        this.costCalculatorService = costCalculatorService;
    }

    public List<WarehouseOrder> findAll(){
        return warehouseOrderRepository.findAll();
    }

    @Transactional
    public WarehouseOrderDTO createOrder(WarehouseOrderDTO dto, Long warehouseId, Long customerId, List<Long> selectedGoodsId){
        WarehouseOrder order = warehouseOrderMapper.map(dto);
        Warehouse warehouse = warehouseRepository.findById(warehouseId).orElseThrow(() -> new WarehouseNotFoundException("Warehouse not found"));
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        order.setWarehouse(warehouse);
        order.setCustomer(customer);
        order.setTotalCosts(0.0);

        List<Goods> selectedGoods = goodsRepository.findAllByIdIn(selectedGoodsId);

        TypeOfGoods commonGoodsType = typeCompatibilityChecking(selectedGoods);

        double sum = calculationRequiredArea(selectedGoods);

        checkingCompatibilityOfGoodsAndWarehouseTypes(warehouse, commonGoodsType);

        checkingRequiredArea(warehouse, sum);

        addingGoodsToOrder(order, selectedGoods);

        calculateAndSetCosts(order);

        warehouseRepository.save(warehouse);
        WarehouseOrder saved = warehouseOrderRepository.save(order);
        return warehouseOrderMapper.map(saved);
    }

    private void calculateAndSetCosts(WarehouseOrder order) {
        Double totalCosts = costCalculatorService.calculateStorageCosts(order);
        order.setTotalCosts(totalCosts);
    }

    private static void addingGoodsToOrder(WarehouseOrder order, List<Goods> selectedGoods) {
        selectedGoods.forEach(goods -> {
            goods.setAssignedToOrder(true);
            order.getGoods().add(goods);
        });
    }

    private static void checkingRequiredArea(Warehouse warehouse, double sum) {
        if (warehouse.getAvailableArea() < sum){
            throw new InsufficientWarehouseSpaceException("Not enough space in the warehouse");
        } else {
            warehouse.setAvailableArea(warehouse.getAvailableArea() - sum);
        }
    }

    private static void checkingCompatibilityOfGoodsAndWarehouseTypes(Warehouse warehouse, TypeOfGoods commonGoodsType) {
        if (commonGoodsType != warehouse.getTypeOfGoods()) {
            throw new IncompatibleGoodsTypeException("The type of goods is not compatible with the warehouse type");
        }
    }

    private static double calculationRequiredArea(List<Goods> selectedGoods) {
        return selectedGoods.stream()
                .mapToDouble(Goods::getRequiredArea).sum();
    }

    private static TypeOfGoods typeCompatibilityChecking(List<Goods> selectedGoods) {
        TypeOfGoods commonGoodsType = selectedGoods.stream()
                .map(Goods::getTypeOfGoods)
                .reduce((firstType, secondType) -> {
                    if (firstType != secondType) {
                        throw new IncompatibleGoodsTypeException("Not all goods have the same type");
                    }
                    return firstType;
                })
                .orElseThrow(() -> new NoGoodsSelectedException("No goods selected"));
        return commonGoodsType;
    }

}
