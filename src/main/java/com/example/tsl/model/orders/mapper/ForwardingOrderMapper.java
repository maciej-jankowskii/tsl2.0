package com.example.tsl.model.orders.mapper;

import com.example.tsl.model.orders.forwarderOrder.ForwardingOrder;
import com.example.tsl.model.orders.forwarderOrder.ForwardingOrderDTO;
import org.springframework.stereotype.Service;

@Service
public class ForwardingOrderMapper {

    public ForwardingOrder map(ForwardingOrderDTO forwardingOrderDTO) {
        ForwardingOrder order = new ForwardingOrder();
        order.setOrderNumber(forwardingOrderDTO.getOrderNumber());
        order.setPrice(forwardingOrderDTO.getPrice());
        order.setTypeOfTruck(forwardingOrderDTO.getTypeOfTruck());
        order.setTruckNumbers(forwardingOrderDTO.getTruckNumbers());

        return order;
    }

    public ForwardingOrderDTO map(ForwardingOrder forwardingOrder) {
        ForwardingOrderDTO dto = new ForwardingOrderDTO();
        dto.setOrderNumber(forwardingOrder.getOrderNumber());
        dto.setPrice(forwardingOrder.getPrice());
        dto.setTypeOfTruck(forwardingOrder.getTypeOfTruck());
        dto.setTruckNumbers(forwardingOrder.getTruckNumbers());
        return dto;
    }
}
