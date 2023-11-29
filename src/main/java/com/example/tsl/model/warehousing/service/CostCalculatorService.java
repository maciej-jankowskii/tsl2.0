package com.example.tsl.model.warehousing.service;

import com.example.tsl.model.warehousing.goods.Goods;
import com.example.tsl.model.warehousing.order.WarehouseOrder;
import com.example.tsl.model.warehousing.repository.WarehouseOrderRepository;
import com.example.tsl.model.warehousing.warehouse.Warehouse;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class CostCalculatorService implements StorageCostCalculator{
    private final WarehouseOrderRepository warehouseOrderRepository;

    public CostCalculatorService(WarehouseOrderRepository warehouseOrderRepository) {
        this.warehouseOrderRepository = warehouseOrderRepository;
    }

    @Override
    public Double calculateStorageCosts(WarehouseOrder warehouseOrder) {
        Warehouse warehouse = warehouseOrder.getWarehouse();
        Double costPer100SquareMeters = warehouse.getCostPer100SquareMeters();
        Long dayStored = ChronoUnit.DAYS.between(warehouseOrder.getDateAdded(), warehouseOrder.getDateOfReturn());

        Double requiredArea = getRequiredAreaOffAllGoodsInOrder(warehouseOrder);
        Double totalCost = calculateFinalCost(requiredArea, dayStored, costPer100SquareMeters);

        return totalCost;
    }

    private Double calculateFinalCost(Double requiredArea, Long dayStored, Double costPer100SquareMeters) {
        return (requiredArea / 100) * dayStored * costPer100SquareMeters;
    }

    private static Double getRequiredAreaOffAllGoodsInOrder(WarehouseOrder warehouseOrder) {
        List<Goods> goods = warehouseOrder.getGoods();
        return goods.stream()
                .mapToDouble(Goods::getRequiredArea)
                .sum();

    }
}
