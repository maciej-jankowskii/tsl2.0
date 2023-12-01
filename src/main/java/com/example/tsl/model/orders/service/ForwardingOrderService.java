package com.example.tsl.model.orders.service;

import com.example.tsl.enums.OrderStatus;
import com.example.tsl.exceptions.CargoNotFoundException;
import com.example.tsl.exceptions.CarrierNotFoundException;
import com.example.tsl.exceptions.EmployeeNotFoundException;
import com.example.tsl.model.cargos.Cargo;
import com.example.tsl.model.cargos.CargoMapper;
import com.example.tsl.model.cargos.CargoRepository;
import com.example.tsl.model.cargos.CargoService;
import com.example.tsl.model.contractors.carrier.Carrier;
import com.example.tsl.model.contractors.mapper.CarrierMapper;
import com.example.tsl.model.contractors.repository.CarrierRepository;
import com.example.tsl.model.contractors.service.CarrierService;
import com.example.tsl.model.employees.baseEntity.Employee;
import com.example.tsl.model.employees.baseEntity.EmployeeMapper;
import com.example.tsl.model.employees.officeWorkers.Forwarder;
import com.example.tsl.model.employees.repository.ForwarderRepository;
import com.example.tsl.model.employees.service.EmployeeService;
import com.example.tsl.model.employees.service.ForwarderService;
import com.example.tsl.model.invoices.service.VatCalculatorService;
import com.example.tsl.model.orders.forwarderOrder.ForwardingOrder;
import com.example.tsl.model.orders.forwarderOrder.ForwardingOrderDTO;
import com.example.tsl.model.orders.mapper.ForwardingOrderMapper;
import com.example.tsl.model.orders.repository.ForwardingOrderRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ForwardingOrderService {
    private final ForwardingOrderRepository forwardingOrderRepository;
    private final ForwardingOrderMapper forwardingOrderMapper;
    private final ForwarderService forwarderService;
    private final CargoRepository cargoRepository;
    private final ForwarderRepository forwarderRepository;
    private final CargoService cargoService;
    private final CarrierService carrierService;
    private final CarrierRepository carrierRepository;
    private final VatCalculatorService vatCalculatorService;

    public ForwardingOrderService(ForwardingOrderRepository forwardingOrderRepository, ForwardingOrderMapper forwardingOrderMapper,
                                  ForwarderService forwarderService, CargoRepository cargoRepository, ForwarderRepository forwarderRepository,
                                  CargoService cargoService, CarrierService carrierService, CarrierRepository carrierRepository,
                                  VatCalculatorService vatCalculatorService) {
        this.forwardingOrderRepository = forwardingOrderRepository;
        this.forwardingOrderMapper = forwardingOrderMapper;
        this.forwarderService = forwarderService;
        this.cargoRepository = cargoRepository;
        this.forwarderRepository = forwarderRepository;
        this.cargoService = cargoService;
        this.carrierService = carrierService;
        this.carrierRepository = carrierRepository;
        this.vatCalculatorService = vatCalculatorService;
    }

    public List<ForwardingOrder> findAllByForwarder(Forwarder forwarder){
        return forwardingOrderRepository.findAllByForwarder(forwarder);
    }

    public List<ForwardingOrder> findAll(){
        return forwardingOrderRepository.findAll();
    }

    public List<ForwardingOrder> findForwardingOrderByEmployee(Employee employee){
        if (employee instanceof Forwarder){
            Forwarder forwarder = (Forwarder) employee;
            return forwarder.getForwardingOrders();
        } else {
            return forwardingOrderRepository.findAll();
        }
    }
    @Transactional
    public ForwardingOrderDTO createOrder(ForwardingOrderDTO forwardingOrderDTO, String username){
        Forwarder forwarder = forwarderService.findByEmail(username).orElseThrow(() -> new EmployeeNotFoundException("Forwarder not found"));
        ForwardingOrder order = forwardingOrderMapper.map(forwardingOrderDTO);

        Cargo cargo = findCargoById(forwardingOrderDTO);
        Carrier carrier = findCarrierById(forwardingOrderDTO);

        addAdditionalDataForOrderAndCargo(forwarder, cargo, carrier, order);
        changeCarrierBalance(carrier, order);

        forwarder.getForwardingOrders().add(order);

        cargoRepository.save(cargo);
        forwarderRepository.save(forwarder);
        carrierRepository.save(carrier);

        ForwardingOrder saved = forwardingOrderRepository.save(order);
        return forwardingOrderMapper.map(saved);

    }

    private Carrier findCarrierById(ForwardingOrderDTO forwardingOrderDTO) {
        Long carrierId = forwardingOrderDTO.getCarrier().getId();
        Carrier carrier = carrierService.findById(carrierId).orElseThrow(() -> new CarrierNotFoundException("Carrier not found"));
        return carrier;
    }

    private Cargo findCargoById(ForwardingOrderDTO forwardingOrderDTO) {
        Long cargoId = forwardingOrderDTO.getCargo().getId();
        Cargo cargo = cargoService.findById(cargoId).orElseThrow(() -> new CargoNotFoundException("Cargo not found"));
        return cargo;
    }

    private void changeCarrierBalance(Carrier carrier, ForwardingOrder order) {
        BigDecimal price = checkingBruttoPrice(carrier, order);
        BigDecimal balance = carrier.getBalance();
        carrier.setBalance(balance.add(price));
    }

    private  BigDecimal checkingBruttoPrice(Carrier carrier, ForwardingOrder order) {
        String vatNumber = carrier.getVatNumber();
        BigDecimal orderPrice = order.getPrice();
        return vatCalculatorService.calculateBrutto(orderPrice, vatNumber);
    }

    private static void addAdditionalDataForOrderAndCargo(Forwarder forwarder, Cargo cargo, Carrier carrier, ForwardingOrder order) {
        order.setForwarder(forwarder);
        order.setCargo(cargo);
        order.setCarrier(carrier);
        order.setDateAdded(LocalDate.now());
        order.setOrderStatus(OrderStatus.ASSIGNED_TO_CARRIER);
        order.setIsInvoiced(false);
        order.setCurrency(cargo.getCurrency());

        BigDecimal cargoPrice = cargo.getPrice();
        BigDecimal orderPrice = order.getPrice();

        order.setMargin(cargoPrice.subtract(orderPrice));
        cargo.setAssignedToOrder(true);
    }
}
