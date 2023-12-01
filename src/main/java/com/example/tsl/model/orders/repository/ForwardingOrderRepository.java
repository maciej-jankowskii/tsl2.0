package com.example.tsl.model.orders.repository;

import com.example.tsl.model.employees.officeWorkers.Forwarder;
import com.example.tsl.model.orders.forwarderOrder.ForwardingOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForwardingOrderRepository extends CrudRepository<ForwardingOrder, Long> {

    List<ForwardingOrder> findAllByForwarder(Forwarder forwarder);
    List<ForwardingOrder> findAll();
}
